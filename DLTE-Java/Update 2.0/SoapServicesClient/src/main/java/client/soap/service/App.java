package client.soap.service;

import web.Address;
import web.Employee;
import web.EmployeeSoapService;
import web.EmployeeSoapServiceService;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

     //   EmployeeSoapService employeeSoapService=new EmployeeSoapService();
         EmployeeSoapServiceService employeeSoapServiceService=new EmployeeSoapServiceService();
         EmployeeSoapService employeeSoapService=employeeSoapServiceService.getEmployeeSoapServicePort();
         Employee employee=new Employee();
         employee.setFirstName("Amal");
         employee.setMiddeName("d");
         employee.setLastName("h");
         employee.setEmployeeId(1987);
         employee.setEmail("amal@gmail.com");
         employee.setEmployeePhone(9871236540L);
         Address address=new Address();
         address.setCityName("kozhikode");
         address.setHouseName("new house");
         address.setStreetName("idk street");
         address.setStateName("kerala");
         address.setPincode(987456);
         employee.setPermenantAddress(address);
         employee.setTemporaryAddress(address);
         employeeSoapService.createNewEmployee(employee);
//        List<Employee> emp= employeeSoapService.readAll().getEmployeeList();
//        for (Employee each :emp){
//            System.out.println("\nEmployee :");
//            System.out.println("Employee details\n"+"name :"+each.getFirstName()+" \nEmployee id :"+each.getEmployeeId());
//            System.out.println("Permenant address\nHouse Name:"+each.getPermenantAddress().getHouseName()+ "\nStreet Name :"+each.getPermenantAddress().getStreetName()+" \nCity name :"+each.getPermenantAddress().getCityName()+"\nPincode :"+each.getPermenantAddress().getPincode());
//            System.out.println("Temporary address\nHouse Name:"+each.getTemporaryAddress().getHouseName()+ "\nStreet Name :"+each.getTemporaryAddress().getStreetName()+" \nCity name :"+each.getTemporaryAddress().getCityName()+"\nPincode :"+each.getTemporaryAddress().getPincode());
//
//        }

    }
}
