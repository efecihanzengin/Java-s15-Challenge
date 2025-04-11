import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Library {
    private List<Reader> readers;
    private Map<String, Book> bookMap; // Kitapları ID'leriyle saklamak için

    public Library() {
        this.readers = new ArrayList<>();
        this.bookMap = new HashMap<>(); // HashMap'i başlatıyoruz
    }

    public Collection<Book> getBooks() {
        return bookMap.values(); // Kitapların bir koleksiyonunu döndürür
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void addBook(Book book) {
        if (!bookMap.containsKey(book.getBook_ID())) { // Kitap ID'si zaten var mı kontrol et
            this.bookMap.put(book.getBook_ID(), book); // Kitabı Map'e ekle
            System.out.println(book.getName() + " adlı kitap kütüphaneye eklendi.");
        } else {
            System.out.println("Bu ID'ye sahip bir kitap zaten kütüphanede mevcut.");
        }
    }

    public void removeBook(String bookID) {
        if (bookMap.containsKey(bookID)) {
            Book removedBook = bookMap.remove(bookID); // Kitabı Map'ten çıkar
            System.out.println(removedBook.getName() + " adlı kitap (ID: " + bookID + ") kütüphaneden silindi.");
        } else {
            System.out.println(bookID + " ID'li kitap kütüphanede bulunamadı.");
        }
    }

    public void addReader(Reader reader) {
        this.readers.add(reader);
        System.out.println(reader.getName() + " adlı okuyucu kütüphaneye kaydedildi.");
    }

    public void removeReader(String readerID) {
        Reader readerToRemove = null;
        for (Reader reader : readers) {
            if (reader.getPersonID().equals(readerID)) {
                readerToRemove = reader;
                break;
            }
        }
        if (readerToRemove != null) {
            this.readers.remove(readerToRemove);
            System.out.println(readerID + " ID'li okuyucu kütüphaneden silindi.");
        } else {
            System.out.println(readerID + " ID'li okuyucu kütüphanede bulunamadı.");
        }
    }

    public Book findBook(String bookID) {
        return bookMap.get(bookID); // Kitabı doğrudan ID ile al
    }

    public void lendBook(Reader reader, Book book) {
        if (reader.getBorrowedBooks().size() >= 5) {
            System.out.println(reader.getName() + " adlı okuyucu maksimum kitap sayısına (5) ulaştı. Daha fazla kitap ödünç alamaz.");
            return;
        }

        if (bookMap.containsKey(book.getBook_ID()) && book.getStatus().equals("Müsait")) {
            book.update_status("Ödünçte");
            book.change_owner(reader.getName());
            reader.borrowBook(book); // Okuyucunun ödünç aldığı kitaplara ekle
            System.out.println(book.getName() + " adlı kitap " + reader.getName() + " adlı okuyucuya ödünç verildi.");
            System.out.println(reader.getName() + " için fatura kesildi."); // Basit fatura mesajı
        } else if (!bookMap.containsKey(book.getBook_ID())) {
            System.out.println(book.getName() + " adlı kitap kütüphanede bulunmuyor.");
        } else {
            System.out.println(book.getName() + " adlı kitap şu anda ödünçte.");
        }
    }

    public void takeBackBook(Reader reader, Book book) {
        if (bookMap.containsKey(book.getBook_ID()) && book.getStatus().equals("Ödünçte") && book.getBorrower() != null && book.getBorrower().equals(reader.getName())) {
            book.update_status("Müsait");
            book.change_owner(null); // Ödünç alan bilgisi silindi
            reader.returnBook(book); // Okuyucunun ödünç aldığı kitaplardan çıkar
            System.out.println(book.getName() + " adlı kitap " + reader.getName() + " tarafından iade alındı.");
            System.out.println("İade işlemi için ücret iadesi yapıldı."); // Basit iade mesajı
        } else if (!bookMap.containsKey(book.getBook_ID())) {
            System.out.println(book.getName() + " adlı kitap kütüphanede bulunmuyor.");
        } else if (!book.getStatus().equals("Ödünçte")) {
            System.out.println(book.getName() + " adlı kitap zaten müsait durumda.");
        } else {
            System.out.println(book.getName() + " adlı kitabı bu okuyucu ödünç almamış.");
        }
    }

    public void searchBook(String query) {
        boolean found = false;
        System.out.println("Arama sonuçları:");
        for (Book book : bookMap.values()) {
            if (book.getBook_ID().equalsIgnoreCase(query) ||
                    book.getName().toLowerCase().contains(query.toLowerCase()) ||
                    (book.getAuthor() != null && book.getAuthor().getName().toLowerCase().contains(query.toLowerCase()))) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("'" + query + "' kriterine uygun kitap bulunamadı.");
        }
    }

    public void updateBookInfo(String bookID, String name, Author author, double price, int edition, String status, java.util.Date dateOfPurchase) {
        if (bookMap.containsKey(bookID)) {
            Book bookToUpdate = bookMap.get(bookID);
            bookToUpdate.setName(name);
            bookToUpdate.setAuthor(author);
            bookToUpdate.setPrice(price);
            bookToUpdate.setEdition(edition);
            bookToUpdate.setStatus(status);
            bookToUpdate.setDate_of_purchase(dateOfPurchase);
            System.out.println(bookID + " ID'li kitabın bilgileri güncellendi.");
        } else {
            System.out.println(bookID + " ID'li kitap kütüphanede bulunamadı.");
        }
    }

    public void listBooksByCategory(String category) {
        System.out.println("Kategorideki Kitaplar: " + category);
        boolean found = false;
        for (Book book : bookMap.values()) {
            if ((category.equalsIgnoreCase("Journals") && book instanceof Journals) ||
                    (category.equalsIgnoreCase("StudyBooks") && book instanceof StudyBooks) ||
                    (category.equalsIgnoreCase("Magazines") && book instanceof Magazines)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Bu kategoride kitap bulunamadı.");
        }
    }

    public void listBooksByAuthor(String authorName) {
        System.out.println("Yazara Ait Kitaplar: " + authorName);
        boolean found = false;
        for (Book book : bookMap.values()) {
            if (book.getAuthor() != null && book.getAuthor().getName().toLowerCase().contains(authorName.toLowerCase())) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Bu yazara ait kitap bulunamadı.");
        }
    }
}