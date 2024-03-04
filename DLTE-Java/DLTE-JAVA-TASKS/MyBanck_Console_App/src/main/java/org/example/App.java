package org.example;

import org.example.Services.MyBankServices;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println(ResourceBundle.getBundle("information").getString("app.greet"));
        Scanner scanner=new Scanner(System.in);
        String username,password;
        System.out.println("Enter your username");
        username=scanner.next();
        System.out.println(ResourceBundle.getBundle("information").getString("app.menu"));
        MyBankServices bankServices = new MyBankServices();

//        while (true) {
//
//        }
    }
}
