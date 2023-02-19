public class OrganisationContact {
    private String name;
    private String address;
    private String number;

    OrganisationContact (String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + ", " + address + ", " + number;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
