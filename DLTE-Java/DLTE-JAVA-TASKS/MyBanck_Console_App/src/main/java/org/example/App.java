package org.example;

import org.example.Entities.Customer;
import org.example.Exception.UserNotFoundException;
import org.example.Middleware.UserInformationFileRepository;
import org.example.Services.MyBankServices;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        System.out.println(ResourceBundle.getBundle("information").getString("app.greet"));
        MyBankServices bankServices = new MyBankServices();
       //for entering the data to file for the first time uncomment the below line and execute
        //bankServices.Intialize();
        //
        Scanner scanner = new Scanner(System.in);
        String username, password;
        Customer newCustomer=null;
        App myApp = new App();
        do {
            System.out.println("Enter your username");
            username = scanner.next();
            try {
                newCustomer = bankServices.callValidateUser(username);
            } catch (UserNotFoundException exp) {
                System.out.println(exp);
            }
        }while(newCustomer==null);

        if (newCustomer != null) {
            System.out.println("Enter your password");
            password = scanner.next();
            boolean check = myApp.passwordValidate(newCustomer, password);
            int attempt = 1;
            int count=3;
            if (!check) {
                for (attempt = 2; attempt <= 3; attempt++) {
                    System.out.println("");
                    count--;
                    System.out.println(ResourceBundle.getBundle("information").getString("user.password"));
                    System.out.println(ResourceBundle.getBundle("information").getString("user.passinfo")+" "+count );
                    password = scanner.next();
                    check = myApp.passwordValidate(newCustomer, password);
                    if (check) {

                        attempt=4;
                    }
                };
                System.out.println(ResourceBundle.getBundle("information").getString("account.suspended"));
                logger.log(Level.INFO,ResourceBundle.getBundle("information").getString("log.suspension"));
            }
                while (check) {
                    System.out.println(ResourceBundle.getBundle("information").getString("app.menu"));
                    int choice;
                    System.out.println(ResourceBundle.getBundle("information").getString("app.choice"));
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                                    System.out.println("Enter the amount to be deposited");
                                    Long amount = scanner.nextLong();
                                    try {
                                        bankServices.callDeposit(username, amount);
                                    } catch (UserNotFoundException expection) {
                                        System.out.println(expection);
                                    }

//                                }catch (InputMismatchException expection){
//                                    System.out.println("You have entered the wrong input try again "+expection);
//                                    Scanner scanner = new Scanner(System.in);
//                                }
                                break;

                        case 4:bankServices.callCheck();
                       default: return;
                    }
                }


            }
        }


    public boolean passwordValidate(Customer customer, String password)
            {
                if (customer.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
