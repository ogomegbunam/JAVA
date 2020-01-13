package android.example.java;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static Scanner scanner;
    public static ArrayList<Contacts> contacts;
    public static int id = 0;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming");
        initPage();
    }

    public static void initPage() {
        System.out.println("What can i do for you \n" +
                "\t1. manage your contacts \n" +
                "\t2. send a message\n" +
                "\t3. Quit");
        scanner = new Scanner(System.in);
        int initialChoice = scanner.nextInt();
        switch (initialChoice) {
            case 1:
                manageContacts();
                break;
            case 2:
                sendMessage();
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    private static void sendMessage() {
        System.out.println("Who are you going to send a message ");
        String contactName = scanner.next();

        boolean doesExist = false;


        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(contactName)) {
                doesExist = true;

            }
        }
        if (!doesExist) {
            System.out.println("There is no contact named" + contactName + "saved on this device");
        } else {
            System.out.println("What do you want to send?\n");
            String text = scanner.next();
            id++;
            Message message = new Message(text, contactName, id);
        for ( int i =0; i<contacts.size(); i++){
            if (contacts.get(i).getName().equals(contactName)){
                contacts.get(i).addMessage(message);

            }
        }


        }
        initPage();
    }

    private static void manageContacts() {
        System.out.println("What do you want to do?\n");
        System.out.println("\t1. Add a contact\n" +
                "\t2. Show all contacts\n" +
                "\t3. Remove a contact\n" +
                "\t4. Search contact\n" +
                "\t5. Go back ");

        int initialChoice = scanner.nextInt();
        switch (initialChoice) {
            case 1:
                addNewContact();
                break;
            case 2:
                showAllContacts();
                break;
            case 3:
                removeContact();
                break;
            case 4:
                searchContact();
                break;
            case 5:
                initPage();
                break;
            default:
                break;
        }

    }

    private static void addNewContact() {
        System.out.println("Enter Contact's Name:\n");
        String newName = scanner.next();

        System.out.println("Enter Contact's Number:\n");
        int newNumber = scanner.nextInt();

        System.out.println("Enter Contact's Email:\n");
        String newEmail = scanner.next();

        Contacts newContact = new Contacts(newName, newEmail, newNumber);
        Contacts.add(newContact);
        System.out.println("Contact" + newName + "added successfully");
        initPage();
    }

    private static void showAllContacts() {
        if (contacts.size() > 0) {
            for (int i = 0; i < contacts.size(); i++) {
                contacts.get(i).showContactDetails();
                System.out.println("**********");
            }

        } else {
            System.out.println(" There are not saved contact");
        }
        initPage();
    }

    private static void removeContact() {
        System.out.println("Please Enter Contact's Name\n");
        String contactsName = scanner.next();
        if (!contacts.isEmpty()) {
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getName().equals(contactsName)) {
                    System.out.println("Are you sure you want to delete" + contactsName + "?(Y/N)");
                    String answer = scanner.next();
                    switch (answer) {
                        case "y":
                            for (int j = 0; j < contacts.size(); j++)
                                if (contacts.get(j).getName().equals(contactsName)) {
                                    contacts.remove(contacts.get(j));
                                    System.out.println(contactsName + "deleted successfully");
                                    initPage();
                                }
                            break;
                        case "N":
                            initPage();
                            break;
                        default:
                            break;

                    }

                }

            }

        } else {
            System.out.println("There is no contact with the name of" + contactsName + "saved on this device");
        }

    }

    private static void searchContact() {
        System.out.println("Who are you looking for\n");
        String contactName = scanner.next();
        boolean doesExist = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(contactName)) {
                doesExist = true;
                contacts.get(i).showContactDetails();
                initPage();
            }
        }
        if (!doesExist) {
            System.out.println("There is no contact named" + contactName + "saved on this device");
            initPage();
        }
    }

}
