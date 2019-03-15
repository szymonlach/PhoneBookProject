package pl.lach;

import pl.lach.model.Contact;
import pl.lach.model.PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Contact contact1 = new Contact("John Shepard","490482123");
        Contact contact2 = new Contact("Julia Shepard","490364018");
        Contact contact3 = new Contact("Mike Grand","481749509");
        Contact contact4 = new Contact("Henry Lans","484059489");

        phoneBook.addContactToPhoneBook(contact1);
        phoneBook.addContactToPhoneBook(contact2);
        phoneBook.addContactToPhoneBook(contact3);
        phoneBook.addContactToPhoneBook(contact4);

        phoneBook.findContactsByName("");
        phoneBook.findContactByPhoneNumber("490");
    }
}
