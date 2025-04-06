
import java.util.LinkedList;
import java.util.List;

public class Reader extends Person{

    private List<Book> books;

    public Reader(String name, String personID) {
        super(name, personID);
        this.books = new LinkedList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void purchase_book() {
        System.out.println(getName() + " adlı okuyucu kitap satın aldı (bu özellik henüz tam olarak uygulanmadı).");
        // Tipik bir kütüphane sisteminde okuyucular kitap ödünç alırlar, satın almazlar.
        // Bu metot gereksinimlere göre tekrar değerlendirilebilir.
    }

    public void borrow_book(Book book) {
        // Kitap ödünç alma işleminin detayları daha sonra eklenecek
        System.out.println(getName() + " adlı okuyucu " + book.getName() + " adlı kitabı ödünç almak istiyor.");
    }

    public void return_book(Book book) {
        // Kitap iade etme işleminin detayları daha sonra eklenecek
        System.out.println(getName() + " adlı okuyucu " + book.getName() + " adlı kitabı iade etmek istiyor.");
    }

    public void show_book() {
        System.out.println(getName() + " adlı okuyucunun ödünç aldığı kitaplar:");
        if (books.isEmpty()) {
            System.out.println("Henüz kitap ödünç almamış.");
        } else {
            for (Book book : books) {
                System.out.println("- " + book.getName());
            }
        }
    }

    @Override
    public String whoYouAre() {
        return "Ben bir okuyucuyum ve adım " + getName() + ". ID: " + getPersonID();
    }
}
