import java.util.Date;

class StudyBooks extends Book {
    private String subject;
    private String courseCode;

    public StudyBooks(String book_ID, Author author, String name, double price, int edition, String status, Date date_of_purchase, String subject, String courseCode) {
        super(book_ID, author, name, price, edition, status, date_of_purchase);
        this.subject = subject;
        this.courseCode = courseCode;
    }

    public String getSubject() {
        return subject;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public void display() {
        super.display(); // Önce üst sınıfın display metodunu çağır
        System.out.println("Ders: " + subject);
        System.out.println("Ders Kodu: " + courseCode);
    }


}