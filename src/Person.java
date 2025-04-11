class Person {
    private String name;
    private String address;
    private String phone;
    private String personID;

    public Person(String name, String address, String phone, String personID) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPersonID() {
        return personID;
    }

    public void display() {
        System.out.println("Ad: " + name);
        System.out.println("Adres: " + address);
        System.out.println("Telefon: " + phone);
        System.out.println("ID: " + personID);
    }

    public String whoYouAre() {
        return "Ben bir kişiyim.";
    }
}