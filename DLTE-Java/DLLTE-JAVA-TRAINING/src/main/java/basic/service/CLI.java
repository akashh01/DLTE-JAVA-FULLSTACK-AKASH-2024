package basic.service;

import java.util.Scanner;

import static java.lang.System.exit;

//         Personal Loan
//        Internetbanking
//        Mobile banking
//        FD calculator
public class CLI {
    public static void main(String[] args) {
        int choice=0;
        Scanner scanner= new Scanner(System.in);
        while (true){

        System.out.println("-------------------------Welcome to MyBank------------------------------");
        System.out.println("Choose what would you like to do");
        System.out.println("Press 1 : Personal Loan");
        System.out.println("Press 2 : Internet banking");
        System.out.println("Press 3 : Mobile banking");
        System.out.println("Press 4 : FD calculator ");
        System.out.println("PRESS 5 : TO EXIT");
        choice=scanner.nextInt();
        switch (choice){
            case 1 :
                String borrowerName="",borrowerPan="",borrowerAddress="",borrowerEmail="",borrowerIncomeType="";
                Long mobileNumber=0L,aadhaar=0L;
                System.out.println("Fill your name");
                borrowerName=scanner.next();
                System.out.println("Fill your aadhar number");
                aadhaar= scanner.nextLong();
                System.out.println("Enter your PAN");
                borrowerPan=scanner.next();
                System.out.println("Let us know Income type (saleried/self-employed) ");
                borrowerIncomeType=scanner.next();
                System.out.println("Mention the mobile number");
                mobileNumber=scanner.nextLong();
                System.out.println("Enter the email address");
                borrowerEmail=scanner.next();
                System.out.println("Dear" +borrowerName+ " Thanks for showing intrest in taking the personal loan, your application has been submitted further details will be mailed to you");
            case 2:
                System.out.println("Enter the data to avail internet banking");
                Long accNumber=0L,cardNumber;
                String emailAdd,accName;
                System.out.println("Enter account holders name");
                accName=scanner.next();
                System.out.println("Enter your mobile number");
                mobileNumber=scanner.nextLong();
                System.out.println("Enter your Account Number");
                accNumber=scanner.nextLong();
                System.out.println("Enter the email address");
                emailAdd=scanner.next();
                System.out.println("Enter your debit/credit card number");
                cardNumber=scanner.nextLong();
                System.out.print("Thank you "+accName+", Internet banking facility will be availed soon for you account.");
            case 3:
                System.out.println("Enter the data to avail Mobile Banking");
                String check="";
                System.out.println("Enter account holders name");
                accName=scanner.next();
                System.out.println("Enter your mobile number");
                mobileNumber=scanner.nextLong();
                System.out.println("Enter your Account Number");
                accNumber=scanner.nextLong();
                System.out.println("Enter the email address");
                emailAdd=scanner.next();
                System.out.println("Enter your debit/credit card number");
                cardNumber=scanner.nextLong();
                System.out.println("Is Internet banking available for your account or not? (Yes/No) ");
                check=scanner.next();
                System.out.println("Your upi id is "+mobileNumber+"@bank");
                System.out.print("Thank you"+accName+" Your Mobile banking facility will be activated soon for you account.");
            case 4:
                Long totalInvestment=0L;
                float rateOfIntrest=0F,EstimatedReturn,totalValue;
                int year;
                System.out.println("Enter your total investment");
                totalInvestment=scanner.nextLong();
                System.out.println("Enter the rate of intrests");
                rateOfIntrest=scanner.nextFloat();
                System.out.println("Enter Time period(In years)");
                year=scanner.nextInt();
                EstimatedReturn=totalInvestment+(totalInvestment*rateOfIntrest*year/100);
                totalValue=EstimatedReturn+totalInvestment;
                System.out.println("ESTIMATED RETURN ="+EstimatedReturn +"RS");
                System.out.println("TOTAL RETURN ="+totalValue +"RS");
            case 5:
                exit(0);

        }

    }
    }
}
