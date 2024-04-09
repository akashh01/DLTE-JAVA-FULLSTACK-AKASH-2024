package review.spring.dao.technicalreview.Interfaces;

import review.spring.dao.technicalreview.Entities.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeInterface {
    public String writeEmolyeeToDatabase(Employee employee);
    //public void addressToDb(Address address, int employeeId);
    //public void tempAddressToDb(Address address,int employeeId);
    public List<Employee> getAllEmployee();
    public List<Employee> getEmployeeByPin(int pincode);
    public boolean deleteById(int employeeId);

}
