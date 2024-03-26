package employee.implement.interfaces;

import employee.implement.entites.Address;
import employee.implement.entites.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeInterface {
  public String writeEmolyeeToDatabase(Employee employee) throws SQLException;
  //public void addressToDb(Address address, int employeeId);
  //public void tempAddressToDb(Address address,int employeeId);
  public List<Employee> getAllEmployee();
  public List<Employee> getEmployeeByPin(int pincode);
  public boolean deleteById(int employeeId);

}
