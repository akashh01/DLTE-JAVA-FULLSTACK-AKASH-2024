package org.example;

import java.util.Scanner;

public class CollectDetails {

    public static void main(String[] args) {
        CollectDetails cd=new CollectDetails();
        cd.collectData();


    }
    public void collectData(){
        Employee employee1=new Employee();
        Scanner scanner=new Scanner(System.in);
        //name
        System.out.println("-------Employee Details-------");
        System.out.println("Enter the First name of employee");
        employee1.setFirstName(scanner.next());
        System.out.println("Enter the middle name of employee");
        employee1.setMiddeName(scanner.next());
        System.out.println("Enter the last name of employee");
        employee1.setLastName(scanner.next());
        //address
         Address addressDetails=new Address();
        System.out.println("Enter address details");
        System.out.println("Enter the house name");
        addressDetails.setHouseName(scanner.next());
        System.out.println("Enter the street name");
        addressDetails.setStreetName(scanner.next());
        System.out.println("Enter the city name");
        addressDetails.setCityName(scanner.next());
        System.out.println("Enter the state name");
        addressDetails.setStateName(scanner.next());
        System.out.println("Enter the pincode");
        addressDetails.setPincode(scanner.nextInt());
        //emp id
        System.out.println("Enter the employee id");
        employee1.setEmployeeId(scanner.nextInt());
        System.out.println();


        System.out.println(employee1.getFirstName()+employee1.getMiddeName() +employee1.getLastName()+employee1.getHouseName());
    }

    public void verifyEmailPhone(String email,Long phone){

    }


}
