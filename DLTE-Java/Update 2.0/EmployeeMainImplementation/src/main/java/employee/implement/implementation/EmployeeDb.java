package employee.implement.implementation;

import employee.implement.connection.doConnection;
import employee.implement.entites.Address;
import employee.implement.entites.Employee;
import employee.implement.exceptions.EmployeeExists;
import employee.implement.exceptions.ConnectionException;
import employee.implement.exceptions.NoEmployeeData;
import employee.implement.exceptions.InvalidContactInfo;
import employee.implement.exceptions.InvalidUserDetails;
import employee.implement.interfaces.EmployeeInterface;
import employee.implement.validation.basicValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeDb implements EmployeeInterface {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("informations");
    private static Logger logger= LoggerFactory.getLogger(Employee.class);

    @Override
    public String writeEmolyeeToDatabase(Employee employee) throws InvalidContactInfo,InvalidUserDetails{
            ResourceBundle resourceBundleOne=ResourceBundle.getBundle("exceptions");
            basicValidation validation=new basicValidation();
            validation.validateEmployee(employee);

 //       create table ADDRESS_EMPLOYEE(ADDRESS_ID NUMBER,EMPLOYEE_ID NUMBER,HOUSENAME VARCHAR(100),STREETNAME VARCHAR(100),CITY VARCHAR(50),STATE VARCHAR(50),PINCODE NUMBER,ADDRESS_TYPE NUMBER );
            try {
                doConnection setConnection = new doConnection();
                Connection connection = setConnection.makeConnection();
            String query="insert into EMPLOYEE_DETAILS values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getMiddeName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setLong(4,employee.getEmployeePhone());
            preparedStatement.setInt(5,employee.getEmployeeId());
            preparedStatement.setString(6,employee.getEmail());
            int record=preparedStatement.executeUpdate();

            String permAddressQuery = "insert into ADDRESS_EMPLOYEE(ADDRESS_ID,EMPLOYEE_ID,HOUSENAME,STREETNAME,CITY,STATE,PINCODE,ADDRESS_TYPE) values (address_ID_seq.nextval,?,?,?,?,?,?,1)";
            preparedStatement= connection.prepareStatement(permAddressQuery);
            preparedStatement.setInt(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getPermenantAddress().getHouseName());
            preparedStatement.setString(3,employee.getPermenantAddress().getStreetName());
            preparedStatement.setString(4,employee.getPermenantAddress().getCityName());
            preparedStatement.setString(5,employee.getPermenantAddress().getStateName());
            preparedStatement.setInt(6,employee.getPermenantAddress().getPincode());
            int recordOne = preparedStatement.executeUpdate();

            String tempAddressQuery = "insert into ADDRESS_EMPLOYEE(ADDRESS_ID,EMPLOYEE_ID,HOUSENAME,STREETNAME,CITY,STATE,PINCODE,ADDRESS_TYPE) values (address_ID_seq.nextval,?,?,?,?,?,?,0)";
            preparedStatement= connection.prepareStatement(tempAddressQuery);
                preparedStatement.setInt(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getTemporaryAddress().getHouseName());
            preparedStatement.setString(3,employee.getTemporaryAddress().getStreetName());
            preparedStatement.setString(4,employee.getTemporaryAddress().getCityName());
            preparedStatement.setString(5,employee.getTemporaryAddress().getStateName());
            preparedStatement.setInt(6,employee.getTemporaryAddress().getPincode());
            int recordThree=preparedStatement.executeUpdate();
            if(record!=0&&recordOne!=0&&recordThree!=0){
                logger.info(resourceBundle.getString("employee.added"));
                preparedStatement.close();
                connection.close();
                return "EXC000";
            }
            preparedStatement.close();
            connection.close();
            logger.info(resourceBundle.getString("employee.not.added"));
            return "EXC001";
        }catch (ConnectionException exp) {
                throw new ConnectionException();
            }
        catch (SQLIntegrityConstraintViolationException sql){
            throw new EmployeeExists();
        }
            catch (SQLException exp){
                System.out.println(exp);
            }
            return null;

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            doConnection setConnection = new doConnection();
            Connection connection = setConnection.makeConnection();
            String query = "select e.employeeid,e.firstname,e.middlename,e.lastname,e.phone,e.email,t.housename,t.streetname,\n" +
                    "t.city,t.state,t.pincode from employee_details e join address_employee t on e.employeeid=t.employee_id where t.address_type in (1,0)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setMiddeName(resultSet.getString(3));
                employee.setLastName(resultSet.getString(4));
                employee.setEmployeePhone(resultSet.getLong(5));
                employee.setEmail(resultSet.getString(6));

                Address permanentAddress = new Address();
                permanentAddress.setHouseName(resultSet.getString(7));
                permanentAddress.setStreetName(resultSet.getString(8));
                permanentAddress.setCityName(resultSet.getString(9));
                permanentAddress.setStateName(resultSet.getString(10));
                permanentAddress.setPincode(resultSet.getInt(11));
                Address temporaryAddress = new Address();
                if (resultSet.next()) {
                    temporaryAddress.setHouseName(resultSet.getString(7));
                    temporaryAddress.setStreetName(resultSet.getString(8));
                    temporaryAddress.setCityName(resultSet.getString(9));
                    temporaryAddress.setStateName(resultSet.getString(10));
                    temporaryAddress.setPincode(resultSet.getInt(11));
                }

                employee.setPermenantAddress(permanentAddress);
                employee.setTemporaryAddress(temporaryAddress);

                employeeList.add(employee);

            }
            preparedStatement.close();
            connection.close();
            resultSet.close();
            logger.info(resourceBundle.getString("display.employee"));


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeByPin(int pincode) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            doConnection setConnection = new doConnection();
            Connection connection = setConnection.makeConnection();
            String query=" select e.employeeid,e.firstname,e.middlename,e.lastname,e.phone,e.email,t.housename,t.streetname, t.city,t.state,t.pincode from employee_details e join address_employee t on e.employeeid=t.employee_id where t.address_type in (1,0) and t.pincode=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, pincode);
         //   preparedStatement.setInt(2, pincode);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setMiddeName(resultSet.getString(3));
                employee.setLastName(resultSet.getString(4));
                employee.setEmployeePhone(resultSet.getLong(5));
                employee.setEmail(resultSet.getString(6));

                Address permanentAddress = new Address();
                permanentAddress.setHouseName(resultSet.getString(7));
                permanentAddress.setStreetName(resultSet.getString(8));
                permanentAddress.setCityName(resultSet.getString(9));
                permanentAddress.setStateName(resultSet.getString(10));
                permanentAddress.setPincode(resultSet.getInt(11));
                Address temporaryAddress = new Address();
                if (resultSet.next()) {
                    temporaryAddress.setHouseName(resultSet.getString(7));
                    temporaryAddress.setStreetName(resultSet.getString(8));
                    temporaryAddress.setCityName(resultSet.getString(9));
                    temporaryAddress.setStateName(resultSet.getString(10));
                    temporaryAddress.setPincode(resultSet.getInt(11));
                }

                employee.setPermenantAddress(permanentAddress);
                employee.setTemporaryAddress(temporaryAddress);

                employeeList.add(employee);

            }
            preparedStatement.close();
            connection.close();
            resultSet.close();
            logger.info(resourceBundle.getString("display.employee"));


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }



    @Override
    public boolean deleteById(int employeeId) {
        try{
            doConnection setConnection = new doConnection();
            Connection connection = setConnection.makeConnection();
            System.out.println("hello");
            String query="DELETE FROM EMPLOYEE_DETAILS WHERE EMPLOYEEID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,employeeId);
            int deleteResult=preparedStatement.executeUpdate();
            System.out.println("hello");
            if(deleteResult!=0) {
                return true;
            }
            else if(deleteResult==0){
                throw new NoEmployeeData();
            }
        }catch (SQLException exp){
            System.out.println(exp);
            logger.info(resourceBundle.getString("connection.failed"));;
        }
        return false;
    }
}

