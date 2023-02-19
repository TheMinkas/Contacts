public class PersonContact {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;
    private String number;

    PersonContact(String name, String surname,String birthDate, String gender, String number) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + birthDate + ", " + gender + ", " + number;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getNumber() {
        return number;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}