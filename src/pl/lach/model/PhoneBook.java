package pl.lach.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class PhoneBook {

    private Map<String, Contact> contacts;

    public PhoneBook(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public PhoneBook() {
        this.contacts = new TreeMap<>();
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }


    public boolean addContactToPhoneBook(Contact contact) {
        if (contact.getName() == null || contact.getPhoneNumber() == null)
            throw new NullPointerException("Name and phone number cannot be null");
        if (contact.getPhoneNumber().isEmpty() || contact.getName().isEmpty())
            throw new IllegalArgumentException("Name and phone number cannot be empty");
        if (!contacts.containsKey(contact.getName())) {
            contacts.put(contact.getName(), contact);
            return true;
        } else return false;
    }

    public boolean removeContactFormPhoneBook(String name) {
        return contacts.remove(name) != null;
    }

    public List<Contact> findContactsByName(String name) {
        List<Contact> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(name);

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (pattern.matcher(entry.getKey()).find()) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public List<Contact> findContactByPhoneNumber(String phoneNumber) {
        List<Contact> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(phoneNumber);

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (pattern.matcher(entry.getValue().getPhoneNumber()).find()) {
                result.add(entry.getValue());
            }
        }
        return result;
    }


}
