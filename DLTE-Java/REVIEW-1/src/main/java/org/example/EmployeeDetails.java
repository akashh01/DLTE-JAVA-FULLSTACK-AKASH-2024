package org.example;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeDetails extends CollectCheckData {
    Address temporaryAddress;
    Address permenantAddress;
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeDetails employeeDetails=new EmployeeDetails();
      ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
        ArrayList<Object> arrayEmp=new ArrayList<>();
        //int choice;
        while(true){
            System.out.println("------Welcome------");
            int choice;
            System.out.println("Enter your choice\n1 : Adding new employee data\n2 : Displaying all employee data\n3 : Exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                     Employee employee1=new Employee();
                     System.out.println("Employee data");
                     employeeDetails.collectPersonalData(employee1);
                     arrayEmp.add(employee1);
                     break;
                case 2://employeeDetails.displayData();'
                    readWriteEmployee.writeIntoFile(arrayEmp);
                    ArrayList<Objects> arEmp;
                    arEmp= readWriteEmployee.readFromFile();
                    System.out.println(arEmp.size());
                    System.out.println(arEmp);
//                      for(int index=0;index<arEmp.size();index++){
//                          System.out.println(arEmp.get(index));
//                      }
                     // ;
                    //  employee2= (Employee[])
                     // employee2= (Employee) readWriteEmployee.readFromFile();
                 //   System.out.println(employee2);
                       break;
                case 3: default:return;
            }
        }



      //  employeeDetails.displayData();
    }

    @Override
    public void collectPersonalData(Employee employee1) {
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
        //address
         permenantAddress= collectAddress();
         System.out.println("Enter your permenant address");
         

//         System.out.println("Enter your temporary address");
//         employee1.setTemporaryAddress((ArrayList)collectAddress());
//        temporaryAddress= (Address) collectAddress();
//        System.out.println("Data collecte");

//        employeeDetails.displayData(employee1);
//        employeeDetails.displayData(permenantAddress);
//        employeeDetails.displayData(temporaryAddress);


    }


    @Override
    public void displayData() {
        //System.out.println(employee1);
        System.out.println("Temporary address");
        System.out.println(temporaryAddress);
        System.out.println("Permenant address");
        System.out.println(permenantAddress);


    }

    @Override
    public Address collectAddress() {
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
        return new Address(houseName,streetName,cityName,stateName,pincode);

    }
}
