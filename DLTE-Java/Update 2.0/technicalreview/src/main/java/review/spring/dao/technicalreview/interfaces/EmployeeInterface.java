package review.spring.dao.technicalreview.interfaces;

import org.springframework.stereotype.Repository;
import review.spring.dao.technicalreview.entities.Employee;

import java.util.List;

@Repository
public interface EmployeeInterface {
    public String writeEmolyeeToDatabase(Employee employee);
    //public void addressToDb(Address address, int employeeId);
    //public void tempAddressToDb(Address address,int employeeId);
    public List<Employee> getAllEmployee();
    public List<Employee> getEmployeeByPin(int pincode);
    public boolean deleteById(int employeeId);

}
