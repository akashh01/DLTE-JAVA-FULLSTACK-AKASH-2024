package org.example;

import employee.implement.EmployeeDb;
import employee.implement.EmployeeInterface;
import org.example.entites.Address;
import org.example.entites.Employee;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
    public static void main(String[] args) {
        App app = new App();
        System.out.println(resourceBundle.getString("collect.greet"));
        employee.implement.entites.Employee employeeMain;
        employee.implement.entites.Address permenantAddress;
        employee.implement.entites.Address temporaryAddress;
        Address localPermenantAddress=new Address();
        Address localtemporaryAddress=new Address();
        EmployeeInterface employeeInterface = new EmployeeDb();
        Employee employee1; //employee from this class
        employee1 = new Employee();
        Scanner scannerOne = new Scanner(System.in);
        List<employee.implement.entites.Employee> empList=new ArrayList<>();
        while (true) {
            System.out.println(resourceBundle.getString("collect.menu"));
            int choice = scannerOne.nextInt();
            switch (choice) {
                case 1:app.collectPersonalData(employee1);
                       employeeMain = new employee.implement.entites.Employee(employee1.getFirstName(), employee1.getMiddeName(), employee1.getLastName(), employee1.getEmployeePhone(), employee1.getEmployeeId(), employee1.getEmail());
                       employeeInterface.writeEmolyeeToDatabase(employeeMain);
                       app.collectAddress(localPermenantAddress);
                       permenantAddress=new employee.implement.entites.Address(localPermenantAddress.getHouseName(),localPermenantAddress.getStreetName(),localPermenantAddress.getCityName(),localPermenantAddress.getStateName(),localPermenantAddress.getPincode());
                       employeeInterface.addressToDb(permenantAddress,employee1.getEmployeeId());
                       app.collectAddress(localtemporaryAddress);
                       temporaryAddress=new employee.implement.entites.Address(localtemporaryAddress.getHouseName(),localtemporaryAddress.getStreetName(),localtemporaryAddress.getCityName(),localtemporaryAddress.getStateName(),localtemporaryAddress.getPincode());
                       employeeInterface.tempAddressToDb(temporaryAddress,employee1.getEmployeeId());
                       break;
                case 2:empList=employeeInterface.getAllEmployee();
                       List<Employee> employeeList=new ArrayList<>();
                       for (employee.implement.entites.Employee each :empList){
                           System.out.println("Employee details\n"+"name :"+each.getFirstName()+" "+each.getMiddeName()+" "+each.getLastName()+"\nphone: "+each.getEmployeePhone() +" \nEmployee id :"+each.getEmployeeId()+" \nEmail:"+each.getEmail()+"\n");
                           System.out.println("Permenant address\nHouse Name:"+each.getPermenantAddress().getHouseName()+ "\nStreet Name :"+each.getPermenantAddress().getStreetName()+" \nCity name :"+each.getPermenantAddress().getCityName()+"\nPincode :"+each.getPermenantAddress().getPincode()+"\n");
                           System.out.println("Temporary address\nHouse Name:"+each.getTemporaryAddress().getHouseName()+ "\nStreet Name :"+each.getTemporaryAddress().getStreetName()+" \nCity name :"+each.getTemporaryAddress().getCityName()+"\nPincode :"+each.getTemporaryAddress().getPincode());
                       }
                       break;

            }
        }
    }






        public void collectPersonalData(Employee employee1) {
        try {
            //name
            BasicValidation validation=new BasicValidation();
            Scanner scanner=new Scanner(System.in);
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
                if(validation.validateEmail(email)) {
                    employee1.setEmail(email);
                } else {
                    System.out.println("Enter valid employee email");
                    email = scanner.next();
                }
            }

            System.out.println("Enter the employee phone");
            Long phone = scanner.nextLong();
            while (employee1.getEmployeePhone() == null) {
                if (validation.validatePhone(phone)) {
                    employee1.setEmployeePhone(phone);
                } else {
                    System.out.println("Enter valid phone");
                    phone = scanner.nextLong();
                }}
            System.out.println("Enter the employee id");
            employee1.setEmployeeId(scanner.nextInt());
        }
        catch (InputMismatchException expection){
            System.out.println("You have entered wrong input" +expection);
        }
    }

    public void collectAddress(Address address) {
        try {
            BasicValidation validation=new BasicValidation();
            Scanner scanner=new Scanner(System.in);
            //String houseName, streetName, cityName, stateName;
            int pincode=0;
            System.out.println("Enter your address detials");
            System.out.println("Enter the house name");
            address.setHouseName(scanner.nextLine());
            scanner.nextLine();
            System.out.println("Enter the street name");
            address.setStreetName(scanner.nextLine());
            System.out.println("Enter the city name");
            address.setCityName(scanner.nextLine());
            System.out.println("Enter the state name");
            address.setStateName(scanner.nextLine());
            System.out.println("Enter the pincode");
            int pin = scanner.nextInt();
            while(pincode==0) {
                if (validation.validatePincode(pin)) {
                    pincode=pin;
                    address.setPincode(pin);
                } else {
                    System.out.println("Enter the pincode");
                    pin = scanner.nextInt();
                }
            }
            //logger.info(resourceBundleTwo.getString("address.added"));
            // hashPermenantAdd.put(empId, new Address(houseName,streetName,cityName,stateName,pincode));
        }
        catch (InputMismatchException expection){
            System.out.println("You have entered wrong input"+ expection);
        }

    }





    }

