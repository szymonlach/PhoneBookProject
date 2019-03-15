package pl.lach.reader;

import pl.lach.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactCsvReader {

    private static final File FILE = new File("PhoneBook.txt");

    public static List<Contact> readFile() {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(";");
                contacts.add(new Contact(split[0], split[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static void saveToFile(Map<String, Contact> contacts) {
        try (FileWriter fileWriter = new FileWriter(FILE)) {
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                fileWriter.write(String.format("%s;%s", entry.getKey(), entry.getValue().getPhoneNumber()));
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
