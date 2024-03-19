package org.example;

import web.Customer;
import web.SoapAccount;
import web.SoapAccountService;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SoapAccountService soapAccountService = new SoapAccountService();
        SoapAccount soapAccount = soapAccountService.getSoapAccountPort();
        System.out.println("--Welcome to My Bank--");
        System.out.println("1->Create a user\n2->Find By UserName\n3->TransactionUpdate");
        System.out.println("Enter your Choice");
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the Username");
                String username = scanner.next();
                System.out.println("Enter your Password");
                String password = scanner.next();
                System.out.println("Enter your Address");
                String Address = scanner.next();
                System.out.println("Enter your email");
                String email = scanner.next();
                System.out.println("Enter your Contact");
                Long contact = scanner.nextLong();
                Long initialBalance = 0L;
                soapAccount.createAccount(username, password, Address, email, contact, initialBalance);
                System.out.println("User Created");
                break;
            case 2:
                String user = "prash02";
                List<Customer> cards = soapAccount.findUser(user).getCustomerList();
                if (cards.get(0).getUsername() != null) {
                    for (Customer each : cards) {
                        System.out.println("Username: " + each.getUsername() + " Password: " + each.getPassword() + " Initial Balance: " + each.getInitialBalace());
                    }
                } else {
                    System.out.println("User Not Found");
                }

                break;
            case 3:
                System.out.println("Enter your Username");
                String Username = scanner.next();
                System.out.println("Enter the amount to be Deposited");
                Long Amount = scanner.nextLong();
                soapAccount.transactionUpdate(Username, Amount);
                System.out.println("Transaction Updated");
                break;

            default:
                System.out.println("Invalid Choice");
                return;
        }

    }
}