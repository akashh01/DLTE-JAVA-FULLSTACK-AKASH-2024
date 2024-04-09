package review.spring.dao.technicalreview.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import review.spring.dao.technicalreview.Entities.Employee;
import review.spring.dao.technicalreview.Interfaces.EmployeeInterface;

import java.util.List;

public class EmployeeDb implements EmployeeInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String writeEmolyeeToDatabase(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList=jdbcTemplate.query("select e.employeeid,e.firstname,e.middlename,e.lastname,e.phone,e.email,t.housename,t.streetname, t.city,t.state,t.pincode from employee_details e join address_employee t on e.employeeid=t.employee_id where t.address_type in (1,0)",new EmployeeMapper());
        return null;
    }
    public class EmployeeMapper implements RowMapper<Employee,>

    @Override
    public List<Employee> getEmployeeByPin(int pincode) {
        return null;
    }

    @Override
    public boolean deleteById(int employeeId) {
        return false;
    }
}
