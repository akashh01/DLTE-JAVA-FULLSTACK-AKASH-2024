package org.example;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class EmployeeDetails extends CollectCheckData {
    Address temporaryAddress;
    Address permenantAddress;
   // static HashMap<Integer,Object> hashPermenantAdd=new HashMap<>();
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeDetails employeeDetails=new EmployeeDetails();
        ArrayList<Object> arrayEmployee=new ArrayList<>();
        ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
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
                     arrayEmployee=readWriteEmployee.readFromFile();
                     employeeDetails.collectPersonalData(employee1);
                     arrayEmployee.add(employee1);
                     System.out.println(arrayEmployee.size());
                     readWriteEmployee.writeIntoFile(arrayEmployee);
                   // readWriteEmployee.writeIntoFileAddress(hashPermenantAdd);
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
            System.out.println("-------Employee Details-------");
            System.out.println("Enter the First name of employee");
            employee1.setFirstName(scanner.next());
            System.out.println("Enter the middle name of employee");
            employee1.setMiddeName(scanner.next());
            System.out.println("Enter the last name of employee");
            employee1.setLastName(scanner.next());
            //email and phone
            System.out.println("Enter the employee email");
            employeeDetails.email = scanner.next();
            if (employeeDetails.validateEmail()) {
                employee1.setEmail(employeeDetails.email);
            } else {
                System.out.println("Enter valid employee email");
                employeeDetails.email = scanner.next();
            }
            System.out.println("Enter the employee phone");
            employeeDetails.phone = scanner.nextLong();
            if (employeeDetails.validatePhone()) {
                employee1.setEmployeePhone(employeeDetails.phone);
            } else {
                System.out.println("Enter valid phone");
                employeeDetails.phone = scanner.nextLong();
            }
            System.out.println("Enter the employee id");
            employee1.setEmployeeId(scanner.nextInt());
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
        ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
        ArrayList<Object> arEmp;
        arEmp= readWriteEmployee.readFromFile();
        int size=arEmp.size();
        for(int index=0;index<size;index++){
            System.out.println(arEmp.get(index));
        }
//        System.out.println("Temporary address");
//        System.out.println(temporaryAddress);
//        System.out.println("Permenant address");
//        System.out.println(permenantAddress);


    }

    @Override
    public Address collectAddress(int empId) {
        try {
            String houseName, streetName, cityName, stateName;
            int pincode;
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
            pincode = scanner.nextInt();
            // hashPermenantAdd.put(empId, new Address(houseName,streetName,cityName,stateName,pincode));
            return new Address(houseName, streetName, cityName, stateName, pincode);
        }
        catch (InputMismatchException expection){
            System.out.println("You have entered wrong input"+ expection);
            return null;
        }

    }
}
