package exceptions;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Traverse {
    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Scanner scanner=new Scanner(System.in);
        String[] myBankProducts={"CASA","Funds","Card"};
        int index=0;
        logger.log(Level.CONFIG,resourceBundle.getString("members.init"));
        //for index since it is local variable we habe to iiniitalize it
        System.out.println("Enter the postion to ");
        //once the scannner class takes input mismatch exception it will not work agian
        try{
            index=scanner.nextInt();
            logger.log(Level.INFO,resourceBundle.getString("exception.input"));
        }
        //single try multi catch
        catch (InputMismatchException e){
            System.out.println("Exception occured");
            logger.log(Level.WARNING,resourceBundle.getString("exception.input"));
            Scanner scanner1=new Scanner(System.in);
            index=scanner1.nextInt();
            logger.log(Level.INFO,resourceBundle.getString("data.collected"));
            System.out.println(myBankProducts[index]);
            logger.log(Level.INFO,resourceBundle.getString("collected.okay"));

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception occured");
            logger.log(Level.WARNING,resourceBundle.getString("exception.input"));
            index=scanner.nextInt();
            logger.log(Level.INFO,resourceBundle.getString("data.collected"));
        }

        logger.log(Level.INFO,resourceBundle.getString("data.collected"));
        System.out.println(myBankProducts[index]);
        logger.log(Level.INFO,resourceBundle.getString("collected.okay"));
    }
}
