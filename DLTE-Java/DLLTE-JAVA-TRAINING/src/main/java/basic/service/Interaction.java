package basic.service;

import java.util.Scanner;

//command line interaction: Car loan
/*
personal details(name,aadhar,pan,address,mobile,email)
Income: salaried, self-employed: ITR

 */
public class Interaction {
    public static void main(String[] args) {
                 String borrowerName="",borrowerPan="",borrowerAddress="",borrowerEmail="",borrowerIncomeType="";
                 Long mobileNumber=0L,aadhaar=0L;
                 //the 0L indicates that the compiler sould not mis understand mobnmumber for integer
                 Scanner scanner=new Scanner(System.in);
                 System.out.println("-------------------------Welcome to MyBank------------------------------");
                 System.out.println("Fill your name");
                 borrowerName=scanner.nextLine();
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
                 System.out.println("Dear" +borrowerName+ "Thanks for showing intrest in taking the car loan, your application has been sunmitted further details will be mailed to you");


    }
}
