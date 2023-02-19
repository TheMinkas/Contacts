import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook(scanner);

        while (true) {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            String menu = scanner.nextLine();
            switch (menu) {
                case "add":
                    phoneBook.addContact();
                    break;
                case "remove":
                    phoneBook.removeContact();
                    break;
                case "edit":
                    phoneBook.editContact();
                    break;
                case "count":
                    phoneBook.countContacts();
                    break;
                case "list":
                    phoneBook.phoneBookList();
                    break;
                case "exit":
                    phoneBook.closePhoneBook();
                    break;
            }
        }

    }
}