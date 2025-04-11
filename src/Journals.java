import java.util.Date;

class Journals extends Book {
    private int issueNumber;
    private int volumeNumber;

    public Journals(String book_ID, Author author, String name, double price, int edition, String status, Date date_of_purchase, int issueNumber, int volumeNumber) {
        super(book_ID, author, name, price, edition, status, date_of_purchase);
        this.issueNumber = issueNumber;
        this.volumeNumber = volumeNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public int getVolumeNumber() {
        return volumeNumber;
    }

    @Override
    public void display() {
        super.display(); // Önce üst sınıfın display metodunu çağır
        System.out.println("Sayı: " + issueNumber);
        System.out.println("Cilt: " + volumeNumber);
    }
}
