public class Person {
    private String name;
    private String personID;

    public Person(String name, String personID) {
        this.name = name;
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public String getPersonID() {
        return personID;
    }

    public String whoYouAre(){
        return "Ben bir kisiyim ve adim" + this.name + " ve ID'm:" + this.personID;
    }


}
