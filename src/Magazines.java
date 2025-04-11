import java.util.Date;

class Magazines extends Book {
    private Date issueDate;
    private String publisher;

    public Magazines(String book_ID, Author author, String name, double price, int edition, String status, Date date_of_purchase, Date issueDate, String publisher) {
        super(book_ID, author, name, price, edition, status, date_of_purchase);
        this.issueDate = issueDate;
        this.publisher = publisher;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public void display() {
        super.display(); // Önce üst sınıfın display metodunu çağır
        System.out.println("Çıkış Tarihi: " + issueDate);
        System.out.println("Yayıncı: " + publisher);
    }
}
