package pl.lach.controller;

import pl.lach.model.Contact;
import pl.lach.model.PhoneBook;
import pl.lach.options.ProgramOptions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PhoneBookController {

    private Scanner scanner;
    private PhoneBook phoneBook;
    private boolean isRunning;

    public PhoneBookController() {
        scanner = new Scanner(System.in);
        phoneBook = new PhoneBook();
        isRunning = true;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void start() {
        while (isRunning) {
            showOptions();
            try {
                ProgramOptions option = getProgramOptions();
                executeOption(option);
            } catch (NoSuchElementException elementException) {
                System.err.println("Wrong option");
            }
        }
    }

    private ProgramOptions getProgramOptions() {
        System.out.println("Select option");
        int selectedOption = scanner.nextInt();
        scanner.nextLine();
        return ProgramOptions.convert(selectedOption);
    }

    private void showOptions() {
        System.out.println("Options:");
        for (ProgramOptions option : ProgramOptions.values()) {
            System.out.println(option);
        }
    }

    private void executeOption(ProgramOptions option) {

        switch (option) {
            case ADD_NEW_CONTACT:
                addNewContact();
                break;
            case SEARCH_BY_NAME:
                searchByName();
                break;
            case SEARCH_BY_PHONE_NUMBER:
                searchByPhoneNumber();
                break;
            case REMOVE_CONTACT:
                removeContact();
                break;
            case EXIT:
                System.out.println("Goodbye");
                isRunning = false;
                scanner.close();
                break;
        }
    }

    private void removeContact() {
        System.out.println("Enter name of contact you want to delete");
        String enteredContactToDelete = scanner.nextLine();
        boolean result = phoneBook.removeContactFormPhoneBook(enteredContactToDelete);
        if (result) System.out.println("Contact remove");
        else System.err.println("This contact don't exist in phone book");
    }

    private void searchByPhoneNumber() {
        System.out.println("Enter seeking phrase");
        String enteredSeekingPhoneNumber = scanner.nextLine();
        List<Contact> contactByPhoneNumber = phoneBook.findContactByPhoneNumber(enteredSeekingPhoneNumber);
        contactByPhoneNumber.forEach(contact -> System.out.println(String.format("%-15s %s", contact.getName(), contact.getPhoneNumber())));
    }

    private void searchByName() {
        System.out.println("Enter seeking phrase");
        String enteredSeekingName = scanner.nextLine();
        List<Contact> contactsByName = phoneBook.findContactsByName(enteredSeekingName);
        contactsByName.forEach(contact -> System.out.println(String.format("%-15s %s", contact.getName(), contact.getPhoneNumber())));
    }

    private void addNewContact() {
        System.out.println("Enter name:");
        String enteredName = scanner.nextLine();
        System.out.println("Enter phone number:");
        String enteredPhoneNumber = scanner.nextLine();
        boolean response;
        try {
            response = phoneBook.addContactToPhoneBook(new Contact(enteredName, enteredPhoneNumber));
            if (response) System.out.println("Contact added");
            else System.err.println("This contact already exists");
        } catch (NullPointerException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }

}
