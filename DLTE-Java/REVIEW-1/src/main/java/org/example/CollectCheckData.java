package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CollectCheckData {
    String email;
    Long phone=0L;
    //abstract to collect personal data
    public abstract void collectPersonalData();
    //abstract to display those data
    public abstract void displayData(Employee employee);
    //to collect address
    public abstract Object collectAddress();
    //validate email address
    public boolean validateEmail() {
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
      public boolean validatePhone(){
            String phoneRegex = "^[0-9]{10}";
            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phone.toString());
            if (matcher.matches()) {
                return true;

            } else {
                return false;
            }

    }

}
