package org.example;

import org.example.exceptions.NoEmployeeData;
import org.example.middleware.Operations;
import org.example.remotes.CollectCheckData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.EOFException;
import java.io.FileNotFoundException;
import java.util.*;

public class EmployeeDetails implements CollectCheckData {
    //Address temporaryAddress;
    //tAddress permenantAddress;
    static ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
    static ResourceBundle resourceBundleTwo=ResourceBundle.getBundle("loggings");
    private static Logger logger= LoggerFactory.getLogger(EmployeeDetails.class);
    Operations operations=new Operations();
   // static HashMap<Integer,Object> hashPermenantAdd=new HashMap<>();
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeDetails employeeDetails=new EmployeeDetails();
        ArrayList<Object> arrayEmployee=new ArrayList<>();
        ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
        HashMap<Integer,Object> hashPermanantAddress=new HashMap<>();
        HashMap<Integer,Object> hashTemporaryAddress=new HashMap<>();
        //;
        //
        //int choice;
        while(true){
            System.out.println(resourceBundle.getString("collect.greet"));
            int choice;
            System.out.println(resourceBundle.getString("collect.menu"));
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                     //employee details
                     Employee employee1=new Employee();
                     System.out.println(resourceBundle.getString("collect.employee"));
                     arrayEmployee=readWriteEmployee.readFromFile();
                     employeeDetails.collectPersonalData(employee1);
                     arrayEmployee.add(employee1);
                    // System.out.println(arrayEmployee.size());
                     readWriteEmployee.writeIntoFile(arrayEmployee);
                     //employee permanent details
                     hashPermanantAddress=readWriteEmployee.readFromFileAddress("permenant");
                     hashPermanantAddress.put(employee1.getEmployeeId(),employeeDetails.collectAddress());
                     readWriteEmployee.writeIntoFileAddress(hashPermanantAddress,"permanant");
                     //employee temporary details
                     hashTemporaryAddress=readWriteEmployee.readFromFileAddress("temporary");
                     hashTemporaryAddress.put(employee1.getEmployeeId(),employeeDetails.collectAddress());
                     readWriteEmployee.writeIntoFileAddress(hashTemporaryAddress,"temporary");
                     break;
                case 2:employeeDetails.displayData();
                    break;
                case 3: default://return;
            }
        }

      //  employeeDetails.displayData();
    }

    @Override
    public void collectPersonalData(Employee employee1) {
        try {
            EmployeeDetails employeeDetails = new EmployeeDetails();
            //name
            System.out.println(resourceBundle.getString("collect.employee.menu"));
            System.out.println("Enter the First name of employee");
            employee1.setFirstName(scanner.next());
            System.out.println("Enter the middle name of employee");
            employee1.setMiddeName(scanner.next());
            System.out.println("Enter the last name of employee");
            employee1.setLastName(scanner.next());
            //email and phone
            System.out.println("Enter the employee email");
            String email = scanner.next();
            while (employee1.getEmail() == null) {
                if (operations.validateEmail(email)) {
                    employee1.setEmail(email);
                } else {
                    System.out.println("Enter valid employee email");
                    email = scanner.next();
                }
            }

            System.out.println("Enter the employee phone");
            Long phone = scanner.nextLong();
            while (employee1.getEmployeePhone() == null) {
            if (operations.validatePhone(phone)) {
                employee1.setEmployeePhone(phone);
            } else {
                System.out.println("Enter valid phone");
                phone = scanner.nextLong();
            }}
            System.out.println("Enter the employee id");
            employee1.setEmployeeId(scanner.nextInt());
            logger.info(resourceBundleTwo.getString("employee.added"));
        }
        catch (InputMismatchException expection){
            System.out.println("You have entered wrong input" +expection);
        }
        //address
         //permenantAddress= collectAddress(employee1.getEmployeeId());
       //  System.out.println("Enter your permenant address");
     //    hashPermenantAdd.put(employee1.getEmployeeId(),permenantAddress);

//         System.out.println("Enter your temporary address");
//         employee1.setTemporaryAddress((ArrayList)collectAddress());
//        temporaryAddress= (Address) collectAddress();
//        System.out.println("Data collecte");

//        employeeDetails.displayData(employee1);
//        employeeDetails.displayData(permenantAddress);
//        employeeDetails.displayData(temporaryAddress);
      //  HashMap<String, Integer> map = new ArrayList<String, Integer>();

    }


    @Override
    public void displayData() {
        try{
        logger.info(resourceBundleTwo.getString("employee.details"));
        ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
        ArrayList<Object> arEmp;
        arEmp= readWriteEmployee.readFromFile();
        int size=arEmp.size();
        HashMap<Integer,Object> temporaryAddress;
        HashMap<Integer,Object> permanentAddress;
        temporaryAddress=readWriteEmployee.readFromFileAddress("temporary");
        permanentAddress=readWriteEmployee.readFromFileAddress("permanant");
        //System.out.println(temporaryAddress);
        for(int index=0;index<size;index++) {
            System.out.println("Employee " + (index + 1));
            System.out.println(" ");
            System.out.println(arEmp.get(index));
            System.out.println("Permanent address " + permanentAddress.get(((Employee) arEmp.get(index)).getEmployeeId()));
            System.out.println("Temporary address " + temporaryAddress.get(((Employee) arEmp.get(index)).getEmployeeId()));
            System.out.println(" ");
        }}catch (NoEmployeeData notfound){
            System.out.println(notfound);

       }
      //  System.out.println(test.get(456));

//        System.out.println(temporaryAddress);
//        System.out.println("Permenant address");
//        System.out.println(permenantAddress);


    }

    @Override
    public Address collectAddress() {
        try {
            String houseName, streetName, cityName, stateName;
            int pincode=0;
            System.out.println("Enter your address detials");
            System.out.println("Enter the house name");
            houseName = scanner.next();
            scanner.nextLine();
            System.out.println("Enter the street name");
            streetName = scanner.nextLine();
            System.out.println("Enter the city name");
            cityName = scanner.nextLine();
            System.out.println("Enter the state name");
            stateName = scanner.nextLine();
            System.out.println("Enter the pincode");
            int pin = scanner.nextInt();
            while(pincode==0) {
                if (operations.validatePincode(pin)) {
                    pincode = pin;
                } else {
                    System.out.println("Enter the pincode");
                    pin = scanner.nextInt();
                }
            }
            logger.info(resourceBundleTwo.getString("address.added"));
            // hashPermenantAdd.put(empId, new Address(houseName,streetName,cityName,stateName,pincode));
            return new Address(houseName, streetName, cityName, stateName, pincode);
        }
        catch (InputMismatchException expection){
            System.out.println("You have entered wrong input"+ expection);
            return null;
        }

    }

//    public void getDetailsPincode(int pincode){
//        ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
//        ArrayList<Object> arEmp;
//        arEmp= readWriteEmployee.readFromFile();
//        int size=arEmp.size();
//        HashMap<Integer,Object> temporaryAddress;
//        HashMap<Integer,Object> permanentAddress;
//        temporaryAddress=readWriteEmployee.readFromFileAddress("temporary");
//        permanentAddress=readWriteEmployee.readFromFileAddress("permanant");
//        for(int index=0;index<size;index++){
//          if
//
//        }
//    }

}
