package org.example.console;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import employee.implement.exceptions.ConnectionException;
import employee.implement.exceptions.EmployeeExists;
import employee.implement.exceptions.InvalidContactInfo;
import employee.implement.exceptions.InvalidUserDetails;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.entites.Address;
import org.example.entites.Employee;
import org.example.validation.BasicValidation;
import org.example.validation.ReValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.*;

public class ConsoleForWeb {

    public static String printResponse(HttpResponse response) throws IOException {
        // System.out.println(response.getProtocolVersion());
        //  System.out.println(response.getStatusLine().getStatusCode());
        //System.out.println(response.getStatusLine().getReasonPhrase());
        // System.out.println(response.getStatusLine().toString());
        //  System.out.println(EntityUtils.toString(response.getEntity()));
        // Gson gson=new Gson();
        String jjson = EntityUtils.toString(response.getEntity());
        System.out.println(jjson);
        //  JsonObject o=new JsonObject(jjson);
        //Customer customer = gson.fromJson(jjson, Customer.class);
        //System.out.println("customer is "+ customer.getUsername());
        return jjson;
    }

    static ResourceBundle resourceBundle = ResourceBundle.getBundle("information");
    static ResourceBundle resourceBundleOne = ResourceBundle.getBundle("exceptions");
    public static String url = "http://localhost:7001/REST_SERVICES/";

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        ConsoleForWeb consoleForWeb = new ConsoleForWeb();
        // consoleForWeb.displayAll();
        Scanner scannerOne = new Scanner(System.in);
        while (true) {
            System.out.println(resourceBundle.getString("collect.menu"));
            int choice = scannerOne.nextInt();
            switch (choice) {
                //to fetch employee data from the user
                case 1:
                    do {
                        String checkAgain = "first";
                        Employee employee1 = new Employee();
                        String check;
                        employee1 = consoleForWeb.collectPersonalData();
                        boolean flag = true;
                        consoleForWeb.writeEmployee(employee1);
                        System.out.println("Do you want to add another employee?");

                    } while (scannerOne.next().equalsIgnoreCase("yes"));
                    break;
                case 2:consoleForWeb.displayAll();
            }

        }
    }



    public void writeEmployee(Employee employee) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url + "/addEmployee/");
        Gson gson=new Gson();
        String writeData = gson.toJson(employee);
        //httppost.setEntity(new UrlEncodedFormEntity(writeData, "UTF-8"));
        StringEntity entity=new StringEntity(writeData);
        httppost.setEntity(entity);
        httppost.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = httpclient.execute(httppost);
    }



    public void displayAll() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url + "/allemployee/");
        CloseableHttpResponse response = httpclient.execute(httpget);
        Gson gson = new Gson();
        String jjson = printResponse(response);
        //     JsonArray o=new JsonArray();
        //   List<Employee> employee = (List<Employee>) gson.fromJson(jjson,  Employee.class);
//        JsonParser parser=new JsonParser();
//        JsonArray employee=parser.parse(jjson).getAsJsonArray();
        Type listType = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        List<Employee> employeeList = new Gson().fromJson(jjson, listType);
        System.out.println(employeeList);
        employeeList.get(0).getTemporaryAddress();
        //System.out.println("customer is "+ customer.getUsername());
        int count = 0;
        for (Employee each : employeeList) {
            System.out.println("\nEmployee :" + count++);
            System.out.println("Employee details\n" + "name :" + each.getFirstName() + " \nEmployee id :" + each.getEmployeeId());
            System.out.println("Permenant address\nHouse Name:" + each.getPermenantAddress().getHouseName() + "\nStreet Name :" + each.getPermenantAddress().getStreetName() + " \nCity name :" + each.getPermenantAddress().getCityName() + "\nPincode :" + each.getPermenantAddress().getPincode());
            System.out.println("Temporary address\nHouse Name:" + each.getTemporaryAddress().getHouseName() + "\nStreet Name :" + each.getTemporaryAddress().getStreetName() + " \nCity name :" + each.getTemporaryAddress().getCityName() + "\nPincode :" + each.getTemporaryAddress().getPincode());

        }
    }



    public Employee collectPersonalData() {
       // App app = new App();
        Employee employee1=new Employee();
        Address localPermenantAddress=new Address();
        Address localtemporaryAddress=new Address();
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
          //  employee1.setEmail(email);
                while (employee1.getEmail() == null) {
                    if (validation.validateEmail(email)) {
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
        ConsoleForWeb consoleForWeb=new ConsoleForWeb();
        consoleForWeb.collectAddress(localPermenantAddress);
       // permenantAddress = new employee.implement.entites.Address(localPermenantAddress.getHouseName(), localPermenantAddress.getStreetName(), localPermenantAddress.getCityName(), localPermenantAddress.getStateName(), localPermenantAddress.getPincode());
        consoleForWeb.collectAddress(localtemporaryAddress);
     //   temporaryAddress = new employee.implement.entites.Address(localtemporaryAddress.getHouseName(), localtemporaryAddress.getStreetName(), localtemporaryAddress.getCityName(), localtemporaryAddress.getStateName(), localtemporaryAddress.getPincode());
        logger.info(resourceBundle.getString("data.collected"));
      //  return new employee.implement.entites.Employee(employee1.getFirstName(), employee1.getMiddeName(), employee1.getLastName(), employee1.getEmployeePhone(), employee1.getEmployeeId(), employee1.getEmail(), permenantAddress, temporaryAddress);
        employee1.setPermenantAddress(localPermenantAddress);
        employee1.setTemporaryAddress(localtemporaryAddress);
        return employee1;
        //logger.info(resourceBundle.getString("employee.added"));

    }

    //to re enter the specific data which failed validation at the backend

    //collect address details from the user
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