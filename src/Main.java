import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Test için birkaç kitap ve okuyucu ekleyelim
        Author author1 = new Author("J.R.R. Tolkien", "Oxford", "123-456-7890", "A001");
        Author author2 = new Author("George Orwell", "London", "987-654-3210", "A002");
        Journals journal1 = new Journals("J101", author1, "Bilimsel Araştırmalar Dergisi", 35.0, 2, "Müsait", new Date(), 15, 3);
        StudyBooks studyBook1 = new StudyBooks("S201", author2, "Java Programlama", 45.0, 1, "Müsait", new Date(), "Bilgisayar Bilimleri", "CSE101");
        Magazines magazine1 = new Magazines("M301", author1, "National Geographic", 10.0, 10, "Müsait", new Date(), new Date(), "NG Society");
        Book book1 = new Book("B401", author2, "Klasik Roman", 20.0, 5, "Müsait", new Date()); // Hala bir tane genel kitap tutuyoruz

        library.addBook(journal1);
        library.addBook(studyBook1);
        library.addBook(magazine1);
        library.addBook(book1);

        Reader reader1 = new Reader("Ali", "İzmir", "555-1234567", "R001");
        library.addReader(reader1);

        boolean running = true;
        while (running) {
            System.out.println("\nKütüphane Sistemi Menüsü:");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Ara (ID, İsim, Yazar)");
            System.out.println("3. Kitap Bilgilerini Güncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Kategoriye Göre Kitapları Listele");
            System.out.println("6. Yazara Göre Kitapları Listele");
            System.out.println("7. Kitap Ödünç Al");
            System.out.println("8. Kitap İade Et");
            System.out.println("9. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Yeni Kitap Ekle");
                    System.out.print("Kitap ID: ");
                    String bookIDAdd = scanner.nextLine();
                    System.out.print("Kitap Adı: ");
                    String bookNameAdd = scanner.nextLine();
                    System.out.print("Yazarın Adı: ");
                    String authorNameAdd = scanner.nextLine();
                    System.out.print("Kitap Fiyatı: ");
                    double priceAdd = Double.parseDouble(scanner.nextLine());
                    System.out.print("Kitap Baskısı: ");
                    int editionAdd = Integer.parseInt(scanner.nextLine());
                    System.out.print("Kitap Kategorisi (Journals, StudyBooks, Magazines): ");
                    String categoryAdd = scanner.nextLine();
                    System.out.print("Satın Alma Tarihi (yyyy-MM-dd): ");
                    String purchaseDateAddStr = scanner.nextLine();

                    try {
                        java.util.Date purchaseDateAdd = java.sql.Date.valueOf(purchaseDateAddStr); // Assuming<\ctrl3348>-MM-dd format
                        // Şimdilik basit bir yazar oluşturma
                        Author authorAdd = new Author(authorNameAdd, "N/A", "N/A", "A" + System.currentTimeMillis()); // Basit bir ID oluşturma

                        Book newBook = null;
                        if (categoryAdd.equalsIgnoreCase("Journals")) {
                            System.out.print("Sayı Numarası: ");
                            int issueNumberAdd = Integer.parseInt(scanner.nextLine());
                            System.out.print("Cilt Numarası: ");
                            int volumeNumberAdd = Integer.parseInt(scanner.nextLine());
                            newBook = new Journals(bookIDAdd, authorAdd, bookNameAdd, priceAdd, editionAdd, "Müsait", purchaseDateAdd, issueNumberAdd, volumeNumberAdd);
                        } else if (categoryAdd.equalsIgnoreCase("StudyBooks")) {
                            System.out.print("Ders: ");
                            String subjectAdd = scanner.nextLine();
                            System.out.print("Ders Kodu: ");
                            String courseCodeAdd = scanner.nextLine();
                            newBook = new StudyBooks(bookIDAdd, authorAdd, bookNameAdd, priceAdd, editionAdd, "Müsait", purchaseDateAdd, subjectAdd, courseCodeAdd);
                        } else if (categoryAdd.equalsIgnoreCase("Magazines")) {
                            System.out.print("Çıkış Tarihi (yyyy-MM-dd): ");
                            String issueDateAddStr = scanner.nextLine();
                            System.out.print("Yayıncı: ");
                            String publisherAdd = scanner.nextLine();
                            try {
                                java.util.Date issueDateAdd = java.sql.Date.valueOf(issueDateAddStr);
                                newBook = new Magazines(bookIDAdd, authorAdd, bookNameAdd, priceAdd, editionAdd, "Müsait", purchaseDateAdd, issueDateAdd, publisherAdd);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Geçersiz tarih formatı. Lütfen-MM-dd formatında girin.");
                                continue; // Hata olursa döngünün başına dön
                            }
                        } else {
                            newBook = new Book(bookIDAdd, authorAdd, bookNameAdd, priceAdd, editionAdd, "Müsait", purchaseDateAdd);
                        }

                        if (newBook != null) {
                            library.addBook(newBook);
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Geçersiz tarih formatı. Lütfen-MM-dd formatında girin.");
                    }
                    break;
                case "2":
                    System.out.print("Arama kriterini girin: ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;
                case "3":
                    System.out.println("Kitap Bilgilerini Güncelle");
                    System.out.print("Güncellenecek kitabın ID'sini girin: ");
                    String bookIDUpdate = scanner.nextLine();
                    Book bookToUpdate = library.findBook(bookIDUpdate);

                    if (bookToUpdate != null) {
                        System.out.println("Mevcut Bilgiler:");
                        bookToUpdate.display(); // Mevcut kitap bilgilerini göster

                        System.out.print("Yeni Kitap Adı (Enter tuşuna basarak değiştirmeyebilirsiniz): ");
                        String newBookName = scanner.nextLine();
                        if (!newBookName.isEmpty()) {
                            bookToUpdate.setName(newBookName);
                        }

                        System.out.print("Yeni Yazarın Adı (Enter tuşuna basarak değiştirmeyebilirsiniz): ");
                        String newAuthorName = scanner.nextLine();
                        if (!newAuthorName.isEmpty()) {
                            // Basit bir yazar güncelleme (daha gelişmiş bir çözümde yazar kontrolü yapılabilir)
                            Author newAuthor = new Author(newAuthorName, "N/A", "N/A", "A" + System.currentTimeMillis());
                            bookToUpdate.setAuthor(newAuthor);
                        }

                        System.out.print("Yeni Fiyatı (Enter tuşuna basarak değiştirmeyebilirsiniz): ");
                        String newPriceStr = scanner.nextLine();
                        if (!newPriceStr.isEmpty()) {
                            try {
                                double newPrice = Double.parseDouble(newPriceStr);
                                bookToUpdate.setPrice(newPrice);
                            } catch (NumberFormatException e) {
                                System.out.println("Geçersiz fiyat formatı.");
                            }
                        }

                        System.out.print("Yeni Baskısı (Enter tuşuna basarak değiştirmeyebilirsiniz): ");
                        String newEditionStr = scanner.nextLine();
                        if (!newEditionStr.isEmpty()) {
                            try {
                                int newEdition = Integer.parseInt(newEditionStr);
                                bookToUpdate.setEdition(newEdition);
                            } catch (NumberFormatException e) {
                                System.out.println("Geçersiz baskı formatı.");
                            }
                        }

                        System.out.print("Yeni Durumu (Müsait/Ödünç Alınmış) (Enter tuşuna basarak değiştirmeyebilirsiniz): ");
                        String newStatus = scanner.nextLine();
                        if (!newStatus.isEmpty()) {
                            bookToUpdate.setStatus(newStatus);
                        }

                        System.out.print("Yeni Satın Alma Tarihi (yyyy-MM-dd) (Enter tuşuna basarak değiştirmeyebilirsiniz): ");
                        String newPurchaseDateStr = scanner.nextLine();
                        if (!newPurchaseDateStr.isEmpty()) {
                            try {
                                java.util.Date newPurchaseDate = java.sql.Date.valueOf(newPurchaseDateStr);
                                bookToUpdate.setDate_of_purchase(newPurchaseDate);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Geçersiz tarih formatı. Lütfen yyyy-MM-dd formatında girin.");
                            }
                        }

                        System.out.println("Kitap bilgileri güncellendi:");
                        bookToUpdate.display();

                    } else {
                        System.out.println("Belirtilen ID'ye sahip kitap bulunamadı.");
                    }
                    break;
                case "4":
                    System.out.print("Silinecek kitabın ID'sini girin: ");
                    String deleteBookID = scanner.nextLine();
                    library.removeBook(deleteBookID);
                    break;
                case "5":
                    System.out.print("Listelenecek kategoriyi girin (Journals, StudyBooks, Magazines): ");
                    String category = scanner.nextLine();
                    library.listBooksByCategory(category);
                    break;
                case "6":
                    System.out.print("Listelenecek yazarın adını girin: ");
                    String authorName = scanner.nextLine();
                    library.listBooksByAuthor(authorName);
                    break;
                case "7":
                    System.out.print("Ödünç almak isteyen okuyucunun ID'sini girin: ");
                    String readerIDBorrow = scanner.nextLine();
                    // Basit bir okuyucu bulma (gerçek uygulamada daha gelişmiş olabilir)
                    Reader readerBorrow = null;
                    for (Reader r : library.getReaders()) {
                        if (r.getPersonID().equals(readerIDBorrow)) {
                            readerBorrow = r;
                            break;
                        }
                    }
                    if (readerBorrow != null) {
                        System.out.print("Ödünç alınacak kitabın ID'sini girin: ");
                        String bookIDBorrow = scanner.nextLine();
                        // Basit bir kitap bulma (gerçek uygulamada daha gelişmiş olabilir)
                        for (Book b : library.getBooks()) {
                            if (b.getBook_ID().equals(bookIDBorrow)) {
                                library.lendBook(readerBorrow, b);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Okuyucu bulunamadı.");
                    }
                    break;
                case "8":
                    System.out.print("Kitabı iade eden okuyucunun ID'sini girin: ");
                    String readerIDReturn = scanner.nextLine();
                    // Basit bir okuyucu bulma
                    Reader readerReturn = null;
                    for (Reader r : library.getReaders()) {
                        if (r.getPersonID().equals(readerIDReturn)) {
                            readerReturn = r;
                            break;
                        }
                    }
                    if (readerReturn != null) {
                        System.out.print("İade edilecek kitabın ID'sini girin: ");
                        String bookIDReturn = scanner.nextLine();
                        // Basit bir kitap bulma
                        for (Book b : library.getBooks()) {
                            if (b.getBook_ID().equals(bookIDReturn)) {
                                library.takeBackBook(readerReturn, b);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Okuyucu bulunamadı.");
                    }
                    break;
                case "9":
                    running = false;
                    System.out.println("Sistemden çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
        scanner.close();
    }
}