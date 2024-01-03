package com.example.pwmanagerfx;

import java.security.SecureRandom;

public class Randomizer {

    public static String generatePassword() {
        String characters = "QWERTZUIOPASDFGHJKLYXCVBNMqwertzuiopasdfghjklyxcvbnm1234567890!§$%&/()=?#-_+*";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(12);

        for (int i = 0; i < 12; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }
}
