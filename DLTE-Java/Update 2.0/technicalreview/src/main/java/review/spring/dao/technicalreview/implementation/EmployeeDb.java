package review.spring.dao.technicalreview.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import review.spring.dao.technicalreview.entities.Address;
import review.spring.dao.technicalreview.entities.Employee;
import review.spring.dao.technicalreview.exceptions.NoEmployeeData;
import review.spring.dao.technicalreview.interfaces.EmployeeInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class EmployeeDb implements EmployeeInterface {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    Logger logger= LoggerFactory.getLogger(EmployeeDb.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String writeEmolyeeToDatabase(Employee employee) {
        int ack=jdbcTemplate.update("insert into EMPLOYEE_DETAILS values(?,?,?,?,?,?)",new Object[]{
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
            logger.info(resourceBundle.getString("data.collected"));
            return "EXC000";
        }
        else{
            logger.error(resourceBundle.getString("data.collection.error"));
            return "EXC001";
            }

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList=jdbcTemplate.query("SELECT\n" +
                "    e.employeeid,\n" +
                "    e.firstname,\n" +
                "    e.middlename,\n" +
                "    e.lastname,\n" +
                "    e.phone,\n" +
                "    e.email,\n" +
                "    t.housename,\n" +
                "    t.streetname,\n" +
                "    t.city,\n" +
                "    t.state,\n" +
                "    t.pincode,\n" +
                "    p.housename,\n" +
                "    p.streetname,\n" +
                "    p.city,\n" +
                "    p.state,\n" +
                "    p.pincode\n" +
                "FROM\n" +
                "    employee_details e\n" +
                "    JOIN address_employee t ON e.employeeid = t.employee_id  JOIN address_employee p ON e.employeeid = p.employee_id  where t.address_type=0 and p.address_type=1",new EmployeeMapper());
        if(employeeList.isEmpty()){
            logger.warn(resourceBundle.getString("no.emp.data"));
            throw new NoEmployeeData();
        }
        else {
            logger.warn(resourceBundle.getString("employee.list.returned"));
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
            employee.setPermenantAddress(permanentAddress);
            employee.setTemporaryAddress(temporaryAddress);
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
