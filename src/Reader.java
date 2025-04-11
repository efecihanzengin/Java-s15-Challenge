import java.util.ArrayList;
import java.util.List;

class Reader extends Person {
    private String personID;
    private List<Book> borrowedBooks; // Ödünç alınan kitapları tutacak liste

    public Reader(String name, String address, String phone, String personID) {
        super(name, address, phone, personID); // Person sınıfına tüm bilgileri gönderiyoruz
        this.personID = personID;
        this.borrowedBooks = new ArrayList<>(); // Listeyi başlat
    }

    public String getPersonID() {
        return personID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
        System.out.println(book.getName() + " adlı kitap ödünç alındı.");
    }

    public void returnBook(Book book) {
        this.borrowedBooks.remove(book);
        System.out.println(book.getName() + " adlı kitap iade edildi.");
    }

    public void showBorrowedBooks() {
        System.out.println(getName() + " adlı okuyucunun ödünç aldığı kitaplar:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("Henüz kitap ödünç almadı.");
        } else {
            for (Book book : borrowedBooks) {
                book.display();
                System.out.println("---");
            }
        }
    }

    @Override
    public void display() {
        super.display(); // Önce Person sınıfının display metodunu çağır
        System.out.println("Okuyucu ID: " + personID); // Reader'a özel bilgileri ekle
        showBorrowedBooks();
    }
}