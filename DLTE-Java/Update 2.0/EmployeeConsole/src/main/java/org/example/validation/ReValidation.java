package org.example.validation;

import java.util.Scanner;

public class ReValidation {
    public employee.implement.entites.Employee reValidate(String check,employee.implement.entites.Employee emp){
        Scanner scanner=new Scanner(System.in);
        System.out.println("check");
        BasicValidation validation=new BasicValidation();
        if(check.contains("email")){
            System.out.println("Enter the employee email");
            String email = scanner.next();
            while (emp.getEmail() != null) {
                if(validation.validateEmail(email)) {
                    emp.setEmail(email);
                    break;
                } else {
                    System.out.println("Enter valid employee email");
                    email = scanner.next();
                }
            }
        }
        if(check.contains("phone number")){
            System.out.println("Enter the employee phone");
            Long phone = scanner.nextLong();
            while (emp.getEmployeePhone() != null) {
                if (validation.validatePhone(phone)) {
                    emp.setEmployeePhone(phone);
                    break;
                } else {
                    System.out.println("Enter valid phone");
                    phone = scanner.nextLong();
                }}
        }
        if(check.contains("name")){
            System.out.println("Enter the First name of employee");
            while (emp.getFirstName()!=null) {
                String firstName=scanner.next();
                if(validation.validateName(firstName)) {
                    emp.setFirstName(firstName);
                    break;
                } else {
                    System.out.println("Enter first name");

                }
            }
            System.out.println("Enter the middle name of employee");
            while (emp.getMiddeName()==null) {
                String middleName=scanner.next();
                if(validation.validateName(middleName)) {
                    emp.setMiddeName(middleName);
                    break;
                } else {
                    System.out.println("Enter middle name");
                }
            }
            System.out.println("Enter the last name of employee");
            String lastName=scanner.next();
            while (emp.getLastName()==null) {
                if(validation.validateName(lastName)) {
                    emp.setLastName(lastName);
                    break;
                } else {
                    scanner.nextLine();
                    System.out.println("Enter last name");

                }
            }
        }
        //System.out.println(emp.getEmail());
        return emp;

    }
}
