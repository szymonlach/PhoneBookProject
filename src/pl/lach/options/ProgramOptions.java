package pl.lach.options;

import java.util.NoSuchElementException;

public enum ProgramOptions {

    ADD_NEW_CONTACT(1, "Add new contact to phone book"),
    SEARCH_BY_NAME(2, "Search contact by name"),
    SEARCH_BY_PHONE_NUMBER(3, "Search contact by phone number"),
    REMOVE_CONTACT(4, "Remove contact"),
    EXIT(5, "Exit");

    private final int optionNumber;
    private final String description;

    ProgramOptions(int optionNumber, String description) {
        this.optionNumber = optionNumber;
        this.description = description;
    }

    public static ProgramOptions convert(int optionNumber) {
        for (ProgramOptions option : values()) {
            if (optionNumber == option.optionNumber) return option;
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return optionNumber + "->" + description;
    }
}
