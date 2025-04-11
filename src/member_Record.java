import java.util.Date;

class member_Record {
    private String member_ID;
    private Reader reader;
    private String type; // Örneğin: Öğrenci, Öğretim Üyesi
    private Date date_of_membership;
    private int no_books_issued;
    private int max_book_limit;
    private String name;
    private String address;
    private String phone_no;

    public member_Record(String member_ID, Reader reader, String type, Date date_of_membership, String name, String address, String phone_no) {
        this.member_ID = member_ID;
        this.reader = reader;
        this.type = type;
        this.date_of_membership = date_of_membership;
        this.no_books_issued = 0; // Başlangıçta 0 kitap çıkarılmış
        this.max_book_limit = 5; // Varsayılan olarak 5 kitap limiti
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
    }

    public String getMember_ID() {
        return member_ID;
    }

    public Reader getReader() {
        return reader;
    }

    public String getType() {
        return type;
    }

    public Date getDate_of_membership() {
        return date_of_membership;
    }

    public int getNo_books_issued() {
        return no_books_issued;
    }

    public int getMax_book_limit() {
        return max_book_limit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void display() {
        System.out.println("Üyelik Kaydı Bilgileri:");
        System.out.println("Üye ID: " + member_ID);
        System.out.println("Okuyucu Adı: " + (reader != null ? reader.getName() : "Bilinmiyor"));
        System.out.println("Üyelik Tipi: " + type);
        System.out.println("Üyelik Tarihi: " + date_of_membership);
        System.out.println("Çıkarılan Kitap Sayısı: " + no_books_issued);
        System.out.println("Maksimum Kitap Limiti: " + max_book_limit);
        System.out.println("Adres: " + address);
        System.out.println("Telefon: " + phone_no);
    }

    public void update(String address, String phone_no) {
        this.address = address;
        this.phone_no = phone_no;
        System.out.println("Üyelik bilgileri güncellendi.");
    }

    public void inc_book_issued() {
        if (no_books_issued < max_book_limit) {
            no_books_issued++;
        } else {
            System.out.println("Maksimum kitap limitine ulaşıldı.");
        }
    }

    public void dec_book_issued() {
        if (no_books_issued > 0) {
            no_books_issued--;
        }
    }
}
