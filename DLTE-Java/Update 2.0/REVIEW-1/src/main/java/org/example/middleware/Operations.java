package org.example.middleware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {
    public boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+-_]{3,}@[A-Za-z]{3,}(.)[A-Za-z]{2,}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    //validate phone number
    public boolean validatePhone(Long phone){
        String phoneRegex = "^[0-9]{10}";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone.toString());
        if (matcher.matches()) {
            return true;

        } else {
            return false;
        }

}
    public boolean validatePincode(int pin){
        String pinRegex = "^[0-9]{6}";
        Pattern pattern = Pattern.compile(pinRegex);
        Matcher matcher = pattern.matcher(String.valueOf(pin));
        if (matcher.matches()) {
            return true;

        } else {
            return false;
        }
    }

}
