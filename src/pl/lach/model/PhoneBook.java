package pl.lach.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PhoneBook {

    private Map<String, Contact> contacts;

    public PhoneBook(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }


    public void addContactToPhoneBook(Contact contact) {
        contacts.put(contact.getName(), contact);
    }

    public void removeContactFormPhoneBook(String name) {
        contacts.remove(name);
    }

    public void findContactsByName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(name);

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (pattern.matcher(entry.getKey()).find()) {
                stringBuilder.append(String.format("%-15s %s\n", entry.getKey(), entry.getValue().getPhoneNumber()));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public void findContactByPhoneNumber(String phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(phoneNumber);

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (pattern.matcher(entry.getValue().getPhoneNumber()).find()) {
                stringBuilder.append(String.format("%-15s %s\n", entry.getKey(), entry.getValue().getPhoneNumber()));
            }
        }
        System.out.println(stringBuilder.toString());
    }


}
