package org.example;

import employee.implement.EmployeeDb;
import employee.implement.interfaces.EmployeeInterface;
//import employee.implement.NoEmployeeData;
import employee.implement.exceptions.EmployeeExists;
import employee.implement.exceptions.ConnectionException;
import employee.implement.exceptions.InvalidUserDetails;
import employee.implement.exceptions.InvalidContactInfo;
import org.example.entites.Address;
import org.example.entites.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
    static ResourceBundle resourceBundleOne=ResourceBundle.getBundle("exceptions");

    private static Logger logger= LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws SQLException {
        App app = new App();
        System.out.println(resourceBundle.getString("collect.greet"));
        //Employee,address from other class
        employee.implement.entites.Employee employeeMain;
        EmployeeInterface employeeInterface = new EmployeeDb();
        Employee employee1; //employee from this class
        employee1 = new Employee();
        Scanner scannerOne = new Scanner(System.in);
        List<employee.implement.entites.Employee> empList=new ArrayList<>();
        while (true) {
            System.out.println(resourceBundle.getString("collect.menu"));
            int choice = scannerOne.nextInt();
            switch (choice) {
                case 1:do {
                    employeeMain =app.collectPersonalData(employee1);
                    try {
                        String check = employeeInterface.writeEmolyeeToDatabase(employeeMain);
                        System.out.println(resourceBundleOne.getString(check));
                    }catch (EmployeeExists|ConnectionException| InvalidUserDetails|InvalidContactInfo exp){
                        System.out.println(exp);
                    }

                    System.out.println("Do you want to add another employee?");
                   } while (scannerOne.next().equalsIgnoreCase("yes"));
                       break;
                case 2:
                       try {
                           empList = employeeInterface.getAllEmployee();
                       }catch (ConnectionException exp){
                           System.out.println(exp);
                       }
                       logger.info(resourceBundle.getString("employee.details"));
                        List<Employee> employeeList=new ArrayList<>();
                        employeeList=app.translateData(empList);
                        app.displayData(employeeList);
                       break;
                case 3:
                      System.out.println("Enter the pincode");
                      int pincode=scannerOne.nextInt();
                       try {
                          empList = employeeInterface.getEmployeeByPin(pincode);
                       }catch (ConnectionException exp){
                         System.out.println(exp);
                       }
                      List<Employee> employeeListOne=new ArrayList<>();
                      employeeListOne=app.translateData(empList);
                      app.displayData(employeeListOne);

            }
        }
    }

        public List<Employee> translateData(List<employee.implement.entites.Employee> empList){
            List<Employee> employeeList=new ArrayList<>();
            int sizeEmp=empList.size();
            for(int index=0;index<sizeEmp;index++){
                employeeList.add(new Employee());
                employeeList.get(index).setFirstName(empList.get(index).getFirstName());
                employeeList.get(index).setMiddeName(empList.get(index).getMiddeName());
                employeeList.get(index).setLastName(empList.get(index).getLastName());
                employeeList.get(index).setEmail(empList.get(index).getEmail());
                employeeList.get(index).setEmployeePhone(empList.get(index).getEmployeePhone());
                employeeList.get(index).setEmployeeId(empList.get(index).getEmployeeId());
                // employeeList.get(index).setPermenantAddress(empList.get(index).getPermenantAddress());
                Address address=new Address();
                address.setHouseName(empList.get(index).getPermenantAddress().getHouseName());
                address.setStreetName(empList.get(index).getPermenantAddress().getStreetName());
                address.setCityName(empList.get(index).getPermenantAddress().getCityName());
                address.setStateName(empList.get(index).getPermenantAddress().getStateName());
                address.setPincode(empList.get(index).getPermenantAddress().getPincode());
                employeeList.get(index).setPermenantAddress(address);
                Address tempAddress=new Address();
                tempAddress.setHouseName(empList.get(index).getTemporaryAddress().getHouseName());
                tempAddress.setStreetName(empList.get(index).getTemporaryAddress().getStreetName());
                tempAddress.setCityName(empList.get(index).getTemporaryAddress().getCityName());
                tempAddress.setStateName(empList.get(index).getTemporaryAddress().getStateName());
                tempAddress.setPincode(empList.get(index).getTemporaryAddress().getPincode());
                employeeList.get(index).setTemporaryAddress(tempAddress);
            }
            return employeeList;

        }
        public void displayData(List<Employee> employeeList){
            int count=1;
            for (Employee each :employeeList){
                System.out.println("\nEmployee :"+count++);
                System.out.println("Employee details\n"+"name :"+each.getFirstName()+" "+each.getMiddeName()+" "+each.getLastName()+"\nphone: "+each.getEmployeePhone() +" \nEmployee id :"+each.getEmployeeId()+" \nEmail:"+each.getEmail());
                System.out.println("Permenant address\nHouse Name:"+each.getPermenantAddress().getHouseName()+ "\nStreet Name :"+each.getPermenantAddress().getStreetName()+" \nCity name :"+each.getPermenantAddress().getCityName()+"\nPincode :"+each.getPermenantAddress().getPincode());
                System.out.println("Temporary address\nHouse Name:"+each.getTemporaryAddress().getHouseName()+ "\nStreet Name :"+each.getTemporaryAddress().getStreetName()+" \nCity name :"+each.getTemporaryAddress().getCityName()+"\nPincode :"+each.getTemporaryAddress().getPincode());

            }

        }


        public employee.implement.entites.Employee collectPersonalData(Employee employee1) {
            App app = new App();
            Address localPermenantAddress=new Address();
            Address localtemporaryAddress=new Address();
            employee.implement.entites.Address permenantAddress;
            employee.implement.entites.Address temporaryAddress;
        try {
            //name

            BasicValidation validation=new BasicValidation();
            Scanner scanner=new Scanner(System.in);
            System.out.println(resourceBundle.getString("collect.employee.menu"));
            System.out.println("Enter the First name of employee");
            while (employee1.getFirstName()==null) {
                String firstName=scanner.next();
                if(validation.validateName(firstName)) {
                    employee1.setFirstName(firstName);
                    break;
                } else {
                    System.out.println("Enter first name");

                }
            }
            System.out.println("Enter the middle name of employee");
            while (employee1.getMiddeName()==null) {
                String middleName=scanner.next();
                if(validation.validateName(middleName)) {
                    employee1.setMiddeName(middleName);
                    break;
                } else {
                    System.out.println("Enter middle name");
                }
            }
            System.out.println("Enter the last name of employee");
            String lastName=scanner.next();
            while (employee1.getLastName()==null) {
                if(validation.validateName(lastName)) {
                    employee1.setLastName(lastName);
                    break;
                } else {
                    scanner.nextLine();
                    System.out.println("Enter last name");

                }
            }

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
            logger.error(resourceBundle.getString("wrong.details"));
            System.out.println("You have entered wrong input" +expection);
        }
            app.collectAddress(localPermenantAddress);
            permenantAddress = new employee.implement.entites.Address(localPermenantAddress.getHouseName(), localPermenantAddress.getStreetName(), localPermenantAddress.getCityName(), localPermenantAddress.getStateName(), localPermenantAddress.getPincode());
            app.collectAddress(localtemporaryAddress);
            temporaryAddress = new employee.implement.entites.Address(localtemporaryAddress.getHouseName(), localtemporaryAddress.getStreetName(), localtemporaryAddress.getCityName(), localtemporaryAddress.getStateName(), localtemporaryAddress.getPincode());
            logger.info(resourceBundle.getString("data.collected"));
            return new employee.implement.entites.Employee(employee1.getFirstName(), employee1.getMiddeName(), employee1.getLastName(), employee1.getEmployeePhone(), employee1.getEmployeeId(), employee1.getEmail(),permenantAddress,temporaryAddress);
            //logger.info(resourceBundle.getString("employee.added"));
    }

    public void collectAddress(Address address) {
        try {
            BasicValidation validation=new BasicValidation();
            Scanner scanner=new Scanner(System.in);
            //String houseName, streetName, cityName, stateName;
            int pincode=0;
            System.out.println("Enter your address detials");
            System.out.println("Enter the house name");
            while (address.getHouseName() == null) {
                String houseName=scanner.nextLine();
                if(validation.validateAdress(houseName)) {
                    address.setHouseName(houseName);
                } else {
                    System.out.println("Mandatory filed, Enter your house name");
                }
            }
            System.out.println("Enter the street name");
            while (address.getStreetName() == null) {
                String streetName=scanner.nextLine();
                if(validation.validateAdress(streetName)) {
                    address.setStreetName(streetName);
                } else {
                    System.out.println("Mandatory filed, Enter your street name");
                }
            }

            System.out.println("Enter the city name");
            while (address.getCityName()== null) {
                String cityName=scanner.nextLine();
                if(validation.validateAdress(cityName)){
                    address.setCityName(cityName);
                } else {
                    System.out.println("Mandatory filed, Enter your city name");
                }
            }
            System.out.println("Enter the state name");
            while (address.getStateName() == null) {
                String stateName=scanner.nextLine();
                if(validation.validateAdress(stateName)){
                    address.setStateName(stateName);
                } else {
                    System.out.println("Mandatory filed, Enter your state name");
                }
            }
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
            //scanner.close();
            //logger.info(resourceBundleTwo.getString("address.added"));
            // hashPermenantAdd.put(empId, new Address(houseName,streetName,cityName,stateName,pincode));
        }
        catch (InputMismatchException expection){
            System.out.println("You have entered wrong input"+ expection);
            logger.error(resourceBundle.getString("wrong.details"));
        }
        logger.info(resourceBundle.getString("address.added"));

    }

}


