package org.example;

import java.util.ResourceBundle;

public class BankException extends RuntimeException {
    public BankException() {
        System.out.println(ResourceBundle.getBundle("application").getString("bank.data"));
    }
}

