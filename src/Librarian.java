public class Librarian extends Person {
    private String librarianID;

    public Librarian(String name, String address, String phone, String librarianID) {
        super(name, address, phone, librarianID);
        this.librarianID = librarianID;
    }

    public String getLibrarianID() {
        return librarianID;
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println(book.getName() + " adlı kitap kütüphaneye eklendi.");
    }

    public void removeBook(Library library, String bookID) {
        library.removeBook(bookID);
        System.out.println(bookID + " ID'li kitap kütüphaneden silindi.");
    }

    public void lendBook(Library library, Reader reader, Book book) {
        library.lendBook(reader, book);
    }

    // takeBackBook metodu güncellendi:
    public void takeBackBook(Library library, Reader reader, Book book) {
        library.takeBackBook(reader, book); // Artık Reader nesnesini de gönderiyoruz
    }

    @Override
    public String whoYouAre() {
        return "Ben bir kütüphaneciyim ve adım " + getName() + ". ID: " + getLibrarianID();
    }
}