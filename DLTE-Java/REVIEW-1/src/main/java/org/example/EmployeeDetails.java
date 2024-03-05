package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeDetails extends CollectCheckData {


    Employee employee1=new Employee();
    Address temporaryAddress;
    Address permenantAddress;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        EmployeeDetails employeeDetails=new EmployeeDetails();
        int choice;
        while(true){
            System.out.println("------Welcome------");
            System.out.println("Enter your choice\n1 : Adding new employee data\n2 : Displaying all employee data\n3 : Exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:employeeDetails.collectPersonalData();

                case 2:employeeDetails.displayData(employeeDetails.employee1);
                       return;
                case 3: default:return;
            }
        }



      //  employeeDetails.displayData();
    }

    @Override
    public void collectPersonalData() {
        Scanner scanner=new Scanner(System.in);
        EmployeeDetails employeeDetails=new EmployeeDetails();
        //name
        System.out.println("-------Employee Details-------");
        System.out.println("Enter the First name of employee");
        employee1.setFirstName(scanner.next());
        System.out.println("Enter the middle name of employee");
        employee1.setMiddeName(scanner.next());
        System.out.println("Enter the last name of employee");
        employee1.setLastName(scanner.next());
        //email and phone
        System.out.println("Enter the employee email");
        employeeDetails.email=scanner.next();
        if(employeeDetails.validateEmail()){
            employee1.setEmail(employeeDetails.email);
        }
        else {
            System.out.println("Enter valid employee email");
            employeeDetails.email=scanner.next();
        }
        System.out.println("Enter the employee phone");
        employeeDetails.phone = scanner.nextLong();
        if(employeeDetails.validatePhone()){
            employee1.setEmployeePhone(employeeDetails.phone);
        }
        else {
            System.out.println("Enter valid phone");
            employeeDetails.phone=scanner.nextLong();
        }
        System.out.println("Enter the employee id");
        employee1.setEmployeeId(scanner.nextInt());
        System.out.println("Enter your permenant address");
        permenantAddress= (Address) collectAddress();
//        System.out.println("Enter your temporary address");
//        temporaryAddress= (Address) collectAddress();
//        employeeDetails.displayData(employee1);
//        employeeDetails.displayData(permenantAddress);
//        employeeDetails.displayData(temporaryAddress);
        scanner.close();


    }


    @Override
    public void displayData(Employee employee) {
        System.out.println(employee);


    }

    @Override
    public Object collectAddress() {
        Scanner scanner=new Scanner(System.in);
        String houseName,streetName,cityName,stateName;
        int pincode;
        System.out.println("Enter the house name");
        houseName=scanner.next();
        scanner.nextLine();
        System.out.println("Enter the street name");
        streetName=scanner.nextLine();
        System.out.println("Enter the city name");
        cityName=scanner.nextLine();
        System.out.println("Enter the state name");
        stateName=scanner.nextLine();
        System.out.println("Enter the pincode");
        pincode=scanner.nextInt();
        scanner.close();
        return new Address(houseName,streetName,cityName,stateName,pincode);

    }
}
