package review.spring.dao.technicalreview.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import review.spring.dao.technicalreview.entities.Address;
import review.spring.dao.technicalreview.entities.Employee;
import review.spring.dao.technicalreview.exceptions.NoEmployeeData;
import review.spring.dao.technicalreview.interfaces.EmployeeInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDb implements EmployeeInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String writeEmolyeeToDatabase(Employee employee) {
        int ack=jdbcTemplate.update("insert into EMPLOYEE_DETAILS values(?,?,?,?,?,?))",new Object[]{
                employee.getFirstName(),
                employee.getMiddeName(),
                employee.getLastName(),
                employee.getEmployeePhone(),
                employee.getEmployeeId(),
                employee.getEmail()
        });
        int ackPermenantAddress=jdbcTemplate.update("insert into ADDRESS_EMPLOYEE(ADDRESS_ID,EMPLOYEE_ID,HOUSENAME,STREETNAME,CITY,STATE,PINCODE,ADDRESS_TYPE) values (address_ID_seq.nextval,?,?,?,?,?,?,1)",new Object[]{
                employee.getEmployeeId(),
                employee.getPermenantAddress().getHouseName(),
                employee.getPermenantAddress().getStateName(),
                employee.getPermenantAddress().getCityName(),
                employee.getPermenantAddress().getStateName(),
                employee.getPermenantAddress().getPincode()
        });
        int ackTemporaryAddress=jdbcTemplate.update("insert into ADDRESS_EMPLOYEE(ADDRESS_ID,EMPLOYEE_ID,HOUSENAME,STREETNAME,CITY,STATE,PINCODE,ADDRESS_TYPE) values (address_ID_seq.nextval,?,?,?,?,?,?,0)",new Object[]{
                employee.getEmployeeId(),
                employee.getTemporaryAddress().getHouseName(),
                employee.getTemporaryAddress().getStateName(),
                employee.getTemporaryAddress().getCityName(),
                employee.getTemporaryAddress().getStateName(),
                employee.getTemporaryAddress().getPincode()
        });
        if(ack!=0&&ackPermenantAddress!=0&&ackTemporaryAddress!=0) {
            return "EXC000";
        }
        else{
            return "EXC001";
            }

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList=jdbcTemplate.query("select e.employeeid,e.firstname,e.middlename,e.lastname,e.phone,e.email,t.housename,t.streetname, t.city,t.state,t.pincode from employee_details e join address_employee t on e.employeeid=t.employee_id where t.address_type in (1,0)",new EmployeeMapper());
        if(employeeList.isEmpty()){
            throw new NoEmployeeData();
        }
        else {
            return employeeList;
        }

    }
    public class EmployeeMapper implements RowMapper<Employee>{

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee=new Employee();
            employee.setEmployeeId(rs.getInt(1));
            employee.setFirstName(rs.getString(2));
            employee.setMiddeName(rs.getString(3));
            employee.setLastName(rs.getString(4));
            employee.setEmployeePhone(rs.getLong(5));
            employee.setEmail(rs.getString(6));
            Address permanentAddress = new Address();
            permanentAddress.setHouseName(rs.getString(7));
            permanentAddress.setStreetName(rs.getString(8));
            permanentAddress.setCityName(rs.getString(9));
            permanentAddress.setStateName(rs.getString(10));
            permanentAddress.setPincode(rs.getInt(11));
            Address temporaryAddress = new Address();
            temporaryAddress.setHouseName(rs.getString(12));
            temporaryAddress.setStreetName(rs.getString(13));
            temporaryAddress.setCityName(rs.getString(14));
            temporaryAddress.setStateName(rs.getString(15));
            temporaryAddress.setPincode(rs.getInt(16));
            return employee;
        }
    }


    @Override
    public List<Employee> getEmployeeByPin(int pincode) {
        return null;
    }

    @Override
    public boolean deleteById(int employeeId) {
        return false;
    }
}
