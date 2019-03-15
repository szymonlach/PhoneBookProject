package pl.lach;

import pl.lach.controller.PhoneBookController;

public class Main {
    public static void main(String[] args) {

        PhoneBookController phoneBookController = new PhoneBookController();
        phoneBookController.start();

    }
}
