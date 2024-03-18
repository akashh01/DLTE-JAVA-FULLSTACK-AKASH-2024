package application.db;


import application.db.Entities.Customer;
import application.db.Exception.UserNotFoundException;
import application.db.Middlewares.DatabaseTarget;
import application.db.Middlewares.UserInfoDatabaseRepository;
import application.db.Remotes.StorageTarget;
import application.db.Remotes.UserInfoRepository;
import application.db.Services.UserInfoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;

/**
 * Hello world! -
 *
 */
public class App {
    static  ResourceBundle resourceBundle = ResourceBundle.getBundle("information");
    static Logger logger;
    public static void main(String[] args) throws SQLException {
        System.out.println(ResourceBundle.getBundle("information").getString("app.greet"));
        logger = LoggerFactory.getLogger(App.class);
        StorageTarget storageTarget = new DatabaseTarget();
        UserInfoServices userInfoServices = new UserInfoServices(storageTarget);
//          StringBuilder builder = new StringBuilder("Deposit,0");
//          builder.append("," + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
//         ArrayList<StringBuilder> transactionOne = new ArrayList<>();
//           transactionOne.add(builder);
//       Customer customer2=new Customer("Eeksha", "eeksha123", "Mangalore", "eeksha@gmail", 987455335L, 1000L, transactionOne);
//        userInfoServices.callAddInformation(customer2);
        Scanner scanner = new Scanner(System.in);
        String username, password;
        boolean flag=false;
        //userInfoServices.callDepositAmountInto(fsa,4);
       // username = scanner.next();
        // newCustomer=userInfoServices.callValidateUser(username);
        // App myApp = new App();
        do {
            System.out.println("Enter your username");
            username = scanner.next();
            try {
                flag =userInfoServices.callValidateUser(username);
            } catch (UserNotFoundException exp) {
                System.out.println(exp);
            }
        } while (flag == false);
        if (flag == true) {
            logger.info(resourceBundle.getString("user.valid"));
            System.out.println("Enter your password");
            password = scanner.next();
            boolean check = userInfoServices.callPasswordValidate(username, password);
            int attempt = 1;
            int count = 3;
            if (!check) {
                for (attempt = 2; attempt <= 3; attempt++) {
                    System.out.println("");
                    count--;
                    System.out.println(ResourceBundle.getBundle("information").getString("user.password"));
                    System.out.println(ResourceBundle.getBundle("information").getString("user.passinfo") + " " + count);
                    password = scanner.next();
                    check = userInfoServices.callPasswordValidate(username, password);
                    if (check) {

                        attempt = 4;
                    }
                }
            }
            List<List> transaction=new ArrayList();
            transaction=userInfoServices.callTransactionByDate(username,"13-03-2024");
            System.out.println(transaction);
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
                                logger.info(resourceBundle.getString("user.deposited"));
                                userInfoServices.callDepositAmountInto(username, amount);
                            } catch (UserNotFoundException expection) {
                                logger.error(resourceBundle.getString("deposit.invalid"));
                                System.out.println(expection);
                            }
                            catch (InputMismatchException expection){
                                System.out.println("You have entered the wrong input try again "+expection);
                                //   Scanner scanner = new Scanner(System.in);
                            }
                            break;
                        case 2:case 3: System.out.println(ResourceBundle.getBundle("information").getString("app.notavailable"));
//                        case 4:bankServices.callCheck();
//                            break;
                        default: return;
                    }
                }

                System.out.println(ResourceBundle.getBundle("information").getString("account.suspended"));
                 logger.info(ResourceBundle.getBundle("information").getString("log.suspension"));
            }
        }
    }

