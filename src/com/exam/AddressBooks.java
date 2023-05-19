package com.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBooks {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("======== Address Book ========");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");

            System.out.print("Enter an option: ");
            option = scanner.nextInt();

            scanner.nextLine();

            switch (option) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    findContactByName(scanner);
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

            System.out.println();
        } while (option != 4);
    }
    private static void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter company: ");
        String company = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Contact contact = new Contact(name, company, email, phone);
        contacts.add(contact);

        System.out.println("Contact added.");
    }

    private static void findContactByName(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Phone number: " + contact.getPhone());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found.");
        }
    }

    private static void displayContacts() {
        System.out.println("Name\tCompany\tEmail\tPhone");

        for (Contact contact : contacts) {
            System.out.printf("%s\t%s\t%s\t%s\n",
                    contact.getName(), contact.getCompany(), contact.getEmail(), contact.getPhone());
        }
    }
}


