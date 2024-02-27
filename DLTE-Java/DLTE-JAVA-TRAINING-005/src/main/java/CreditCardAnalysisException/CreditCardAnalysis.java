package CreditCardAnalysisException;

import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class CreditCardAnalysis {
    public static void main(String[] args) {
        //individual customer details stored as objects
        CreditCard[] myBank = {
                new CreditCard(8985122212L, "Akash", new Date(2034, 12, 11), 123, 10000, new Date(2031, 05, 06), new Date(2032, 06, 20), 4567),
                new CreditCard(89851444412L, "Annapoorna", new Date(2029, 10, 21), 153, 30000, new Date(2032, 07, 21), new Date(2038, 06, 5), 4580),
                new CreditCard(89851333312L, "Razaak", new Date(2030, 9, 15), 163, 25000, new Date(2039, 12, 5), new Date(2031, 06, 20), 4500),
        };
        int choice;
        Scanner scanner = new Scanner(System.in);
        //menu for credit card analysis
        while (true) {
            System.out.println("----------CREDIT CARD ANALYSIS------------");
            System.out.println("Choose 1 for filter based on limits\n" + "Choose 2 for filter based on date\n" + "Choose 3 for updating pin number\n" + "Choose 4 to update the limit whose bill genration date is 5\n"+"Choose 5 to exit");
            choice = scanner.nextInt();
            CreditCardAnalysis analysis = new CreditCardAnalysis();
            Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            switch (choice) {
                case 1:
                    //using try catch to catch MyBankCreditCardException
                    try {
                        analysis.FilterOnLimits(myBank);
                        break;
                    }
                    catch (MyBankCreditCardException cardLimit){
                        logger.log(Level.WARNING,cardLimit.toString());
                        analysis.FilterOnLimits(myBank);
                        break;

                    }
                case 2:
                    //using try catch to catch MyBankCreditCardException
                    try{
                        analysis.FilterOnDate(myBank);
                        break;
                    }
                    catch (MyBankCreditCardException cardLimit){
                        logger.log(Level.WARNING,cardLimit.toString());
                        analysis.FilterOnDate(myBank);
                        break;

                    }

                case 3:
                    analysis.PinNumberUpdate(myBank);
                    break;
                case 4:
                    analysis.UpdateLimit(myBank);
                    break;
                case 5:
                    exit(0);

            }
        }
    }

    //to filter customers based on thier credit card limits
    public void FilterOnLimits(CreditCard[] customers) {
        Long StartLimit,EndLimit;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the start range to filter");
        StartLimit = scanner.nextLong();
        System.out.println("Enter the end limit");
        EndLimit = scanner.nextLong();
        boolean flag=true;
        for(CreditCard each: customers){
            if(each.getCreditCardLimit()>=StartLimit &&each.getCreditCardLimit()<=EndLimit){
                flag=false;
                System.out.println(each.getCreditCardHolder()+" Has a limit of "+each.getCreditCardLimit());
            }
        }
        if(flag){
            throw new MyBankCreditCardException();
        }


    }
    //to filter the customer based on the date of bill payment
    public void FilterOnDate(CreditCard[] customers){
        String dateInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date of bill payment in dd/mm/yyyy format");
        dateInput=scanner.next();
        String splitDate[]=dateInput.split("/");
        boolean flag=true;
        for(CreditCard each: customers){
            if((Integer.parseInt(splitDate[0])==(each.getDateOfBillGenearation()).getDate())&&(Integer.parseInt(splitDate[1])==(each.getDateOfBillGenearation()).getMonth())&&(Integer.parseInt(splitDate[2])==(each.getDateOfBillGenearation()).getYear())){
                System.out.println("The account holder "+each.getCreditCardHolder()+" has date of bill on "+dateInput);
                flag=false;
            }
        }
        if(flag){
            throw new MyBankCreditCardException();
        }


    }
    //to change the pin number of a card for a particular user
    public void PinNumberUpdate(CreditCard[] customers)
    {
        int CurrentPin,NewPin;
        Long CreditCardNumber=0L;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your card number for changing password");
        CreditCardNumber=scanner.nextLong();
        for(CreditCard each :customers){
            if(each.getCreditCardNumber().equals(CreditCardNumber)){
                System.out.println("Enter your current pin");
                CurrentPin=scanner.nextInt();
                if(CurrentPin==each.getCreditCardPin()){
                    System.out.println("Enter your new pin");
                    NewPin=scanner.nextInt();
                    each.setCreditCardPin(NewPin);
                    System.out.println("New pin is set");
                }
                else{
                    System.out.println("Wrong pin");
                }
            }

        }
    }

    //50% increase in limit for those customer with bill genaration date 5
    public void UpdateLimit(CreditCard[] customer){
        double NewCreditCardLimit;
        int roundOffNewCreditLimit;
        for(CreditCard each:customer){
            if((each.getDateOfBillGenearation()).getDate()==5){
                NewCreditCardLimit= (each.getCreditCardLimit() * 0.05) + each.getCreditCardLimit();
                roundOffNewCreditLimit= (int) Math.round(NewCreditCardLimit);
                each.setCreditCardLimit(roundOffNewCreditLimit);
                System.out.println("Successfully updated");
            }
        }
    }


}




