import java.util.Date;

class Book implements LibraryItem {
    private String book_ID;
    private Author author;
    private String name;
    private double price;
    private int edition;
    private String status;
    private Date date_of_purchase;
    private String borrower; // Kitabı ödünç alan kişinin bilgisini tutar

    public Book(String book_ID, Author author, String name, double price, int edition, String status, Date date_of_purchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.status = status;
        this.date_of_purchase = date_of_purchase;
        this.borrower = null; // Başlangıçta kitap kimseye ödünç verilmemiştir
    }

    public String getBook_ID() {
        return book_ID;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getEdition() {
        return edition;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    public String getBorrower() {
        return borrower;
    }

    public String get_title() {
        return name;
    }

    public Author get_author() {
        return author;
    }

    public void change_owner(String borrower) {
        this.borrower = borrower;
        System.out.println(this.name + " adlı kitabın sahibi güncellendi: " + borrower);
    }

    public String get_owner() {
        return borrower;
    }

    @Override
    public void display() {
        System.out.println("Kitap Bilgileri:");
        System.out.println("ID: " + book_ID);
        System.out.println("Başlık: " + name);
        System.out.println("Yazar: " + (author != null ? author.getName() : "Bilinmiyor"));
        System.out.println("Fiyat: " + price);
        System.out.println("Baskı: " + edition);
        System.out.println("Durum: " + status);
        System.out.println("Satın Alma Tarihi: " + date_of_purchase);
        if (borrower != null) {
            System.out.println("Ödünç Alan: " + borrower);
        } else {
            System.out.println("Henüz ödünç alınmadı.");
        }
    }

    public void update_status(String status) {
        this.status = status;
        System.out.println(this.name + " adlı kitabın durumu " + status + " olarak güncellendi.");
    }

    @Override
    public String getItemID() {
        return book_ID;
    }
    // Book sınıfının içine eklemeniz gereken setter metotları:

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate_of_purchase(java.util.Date date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }
}