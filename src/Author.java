import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;

    public Author(String name, String address, String phone, String personID) {
        super(name, address, phone, personID);
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void newBook(Book book) {
        this.books.add(book);
        System.out.println(getName() + " adli yazar yeni bir kitap ekledi "+ book.getName());
    }

    public void showBook() {
        System.out.println(getName() + " adlı yazarın kitapları:");
        if (books.isEmpty()) {
            System.out.println("Bu yazarın henüz kitabı bulunmamaktadır.");
        } else {
            for (Book book : books) {
                System.out.println("- " + book.getName());
            }
        }
    }

    @Override
    public String whoYouAre() {
        return "Ben bir yazarım ve adım " + getName() + ". ID: " + getPersonID();
    }
}