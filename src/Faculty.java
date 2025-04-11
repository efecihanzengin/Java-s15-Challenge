import java.util.Date;

class Faculty extends member_Record {
    private String facultyID;

    public Faculty(String member_ID, Reader reader, Date date_of_membership, String name, String address, String phone_no, String facultyID) {
        super(member_ID, reader, "Öğretim Üyesi", date_of_membership, name, address, phone_no);
        this.facultyID = facultyID;
    }

    public String getFacultyID() {
        return facultyID;
    }

    @Override
    public void display() {
        super.display(); // Önce üst sınıfın display metodunu çağır
        System.out.println("Öğretim Üyesi ID: " + facultyID);
    }


}