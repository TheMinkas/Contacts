import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final Scanner scanner;
    private List<PersonContact> personContacts = new ArrayList<>();

    public PhoneBook(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    void addContact() {
        System.out.println("Enter the name of the person: ");
        String name = scanner.nextLine();
        if (name.length() <= 0){
            name = "[no name]";
        }

        System.out.println("Enter the surname of the person: ");
        String surname = scanner.nextLine();
        if (surname.length() <= 0){
            surname = "[no surname]";
        }

        System.out.println("Enter the birth date:");
        String birthDate = scanner.nextLine();
        Matcher matcher1 = Pattern.compile("^(((0[1-9]|[12]\\d|3[01])\\[\\/\\-\\.](0[13578]|1[02])[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)[\\/\\-\\.](0[13456789]|1[012])[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])[\\/\\-\\.]02[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|(29[\\/\\-\\.]02[\\/\\-\\.]((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$")
                .matcher(birthDate);
        if (birthDate.length() <=0) {
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }
        if (matcher1.find()){
        } else {
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }

        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        if (gender.equals("M")){
            gender = "M";
        } else if (gender.equals("F")){
            gender = "F";
        } else {
            gender = "[no data]";
            System.out.println("Bad gender!");
        }

        System.out.println("Enter the number: ");
        String number = scanner.nextLine();
        Matcher matcher2 = Pattern.compile("(^\\s*(\\+?[(]?(\\w{1,})[)]?)$)|((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))$|(((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))([ -](\\w{2,})))$|((((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))([ -](\\w{2,})))([ -](\\w{2,})))$|(((((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))([ -](\\w{2,})))([ -](\\w{2,})))([ -](\\w{2,})))$")
                .matcher(number);
        if (number.length() <= 0){
            System.out.println("Wrong number format");
            number = "[no number]";
        } if (matcher2.find()){
        } else {
            System.out.println("Wrong number format");
            number = "[no number]";
        }
        this.personContacts.add(new PersonContact(name, surname, birthDate, gender, number));

        System.out.println("The record added.\n");
    }
    void countContacts() {
        System.out.println("The Phone Book has " + personContacts.size() + " records.\n");
    }
    void phoneBookList() {
        int count = 0;
        for (int i = 0; i< personContacts.size(); i++){
            count++;
            System.out.println(count + ". " + personContacts.get(i));
        }
    }
    void closePhoneBook() {
        System.exit(0);
    }
    void editContact(){
        phoneBookList();

        if (personContacts.size() == 0){
            System.out.println("No records to edit!");
            return;
        }

        System.out.println("Select a record: ");
        int num = scanner.nextInt();

        System.out.println("Select a field (name, surname, birth, gender, number):");
        while(true) {
            String menu = scanner.nextLine();
            switch (menu){
                case "name":
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    personContacts.get(num-1).setName(name);
                    System.out.println("The record updated!");
                    return;
                case "surname":
                    System.out.println("Enter surname: ");
                    String surname = scanner.nextLine();
                    personContacts.get(num-1).setSurname(surname);
                    System.out.println("The record updated!");
                    return;
                case "birth" :
                    System.out.println("Enter the birth date: ");
                    String birthDate = scanner.nextLine();
                    Matcher matcher1 = Pattern.compile("^(((0[1-9]|[12]\\d|3[01])\\[\\/\\-\\.](0[13578]|1[02])[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)[\\/\\-\\.](0[13456789]|1[012])[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])[\\/\\-\\.]02[\\/\\-\\.]((19|[2-9]\\d)\\d{2}))|(29[\\/\\-\\.]02[\\/\\-\\.]((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$")
                            .matcher(birthDate);
                    if (birthDate.length() <=0) {
                        System.out.println("Bad birth date!");
                        birthDate = "[no data]";
                    }
                    if (matcher1.find()){
                    } else {
                        System.out.println("Bad birth date!");
                        birthDate = "[no data]";
                    }
                    personContacts.get(num-1).setBirthDate(birthDate);
                    System.out.println("The record updated!");
                    return;
                case "gender" :
                    System.out.println("Enter the gender (M, F): ");
                    String gender = scanner.nextLine();
                    if (gender.equals("M")){
                        gender = "M";
                    } else if (gender.equals("F")){
                        gender = "F";
                    } else {
                        gender = "[no data]";
                        System.out.println("Bad gender!");
                    }
                    personContacts.get(num-1).setGender(gender);
                    System.out.println("The record updated!");
                    return;
                case "number":
                    System.out.println("Enter number: ");
                    String number = scanner.nextLine();
                    Matcher matcher = Pattern.compile("(^\\s*(\\+?[(]?(\\w{1,})[)]?)$)|((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))$|(((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))([ -](\\w{2,})))$|((((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))([ -](\\w{2,})))([ -](\\w{2,})))$|(((((^\\s*(\\+?[(]?(\\w{1,})[)]?)([ -](\\w{2,})))|(^\\s*(\\+?(\\w{1,}))([ -][(]?(\\w{2,})[)]?)))([ -](\\w{2,})))([ -](\\w{2,})))([ -](\\w{2,})))$")
                            .matcher(number);
                    if (matcher.find()){
                    } else {
                        System.out.println("Wrong number format");
                        number = "[no number]";
                    }
                    personContacts.get(num-1).setNumber(number);
                    System.out.println("The record updated!");
                    return;
            }
        }


    }
    void removeContact(){
        phoneBookList();

        if (personContacts.size() == 0){
            System.out.println("No records to remove!");
            return;
        }

        System.out.println("Select a record: ");
        int num = scanner.nextInt();

        personContacts.remove(num-1);
        System.out.println("The record removed!");
    }
}