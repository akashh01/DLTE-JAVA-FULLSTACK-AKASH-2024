package employee.implement;

import employee.implement.entites.Address;
import employee.implement.entites.Employee;

import java.util.List;

public interface EmployeeInterface {
  public void writeEmolyeeToDatabase(Employee employee);
  public void addressToDb(Address address, int employeeId);
  public void tempAddressToDb(Address address,int employeeId);
  public List<Employee> getAllEmployee();

}