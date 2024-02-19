package basic.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                 //validating aadhar
                 String aadharExpression="\\d{12,}";
                 Pattern pattern=Pattern.compile(aadharExpression);
                 aadhaar=scanner.nextLong();
                 Matcher matcher= pattern.matcher(aadhaar.toString());
                 while (!matcher.matches()) {
                   System.out.println("Invalid Aadhar Number");
                   System.out.println("Fill your aadhar number");
                   aadhaar=scanner.nextLong();
                   matcher= pattern.matcher(aadhaar.toString());
                 }
                 System.out.println("Aadhar valid");

                 System.out.println("Enter your PAN");
                 borrowerPan=scanner.next();
                 String panExpression="[A-Z]{5}[0-9]{4}[A-Z]{1}";
                 pattern=Pattern.compile(panExpression);
                 matcher=pattern.matcher(borrowerPan);
                 while (!matcher.matches()) {
                     System.out.println("Invalid pan Number");
                     System.out.println("Re-enter your pan number");
                     borrowerPan=scanner.next();
                     matcher= pattern.matcher(borrowerPan);
                 }
                 System.out.println("Pan is valid");
                 System.out.println("Let us know Income type (saleried/self-employed) ");
                 borrowerIncomeType=scanner.next();
                 System.out.println("Mention the mobile number");
                 //validating mobile number
                 String mobileExpression="\\d{10,}";
                 pattern=Pattern.compile(mobileExpression);
                 mobileNumber=scanner.nextLong();
                 matcher= pattern.matcher(mobileNumber.toString());
                 while (!matcher.matches()) {
                     System.out.println("Invalid Mobile Number");
                     System.out.println("Mention the mobile number");
                     mobileNumber=scanner.nextLong();
                     matcher= pattern.matcher(mobileNumber.toString());
                 }
                 System.out.println("Mobile Number valid");
                 System.out.println("Enter the email address");
                 //validating email address
                 String emailExpression="^[A-Za-z0-9+-_]{3,}@(gmail.com)";
                 pattern=Pattern.compile(emailExpression);
                 borrowerEmail=scanner.next();
                 matcher=pattern.matcher(borrowerEmail);
                 while (!matcher.matches()) {
                     System.out.println("Invalid email id");
                     System.out.println("Re-enter the email id");
                     borrowerEmail=scanner.next();
                     matcher= pattern.matcher(borrowerEmail.toString());
                 }
                 System.out.println("Email valid");

                 System.out.println("Dear " +borrowerName+ " Thanks for showing intrest in taking the car loan, your application has been sunmitted further details will be mailed to you");


    }
}
