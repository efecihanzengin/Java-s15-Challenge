import java.util.Date;

class Student extends member_Record {
    private String studentID;

    public Student(String member_ID, Reader reader, Date date_of_membership, String name, String address, String phone_no, String studentID) {
        super(member_ID, reader, "Öğrenci", date_of_membership, name, address, phone_no);
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public void display() {
        super.display(); // Önce üst sınıfın display metodunu çağır
        System.out.println("Öğrenci ID: " + studentID);
    }
}