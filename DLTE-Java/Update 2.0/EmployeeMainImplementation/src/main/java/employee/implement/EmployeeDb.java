package employee.implement;

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
    public String writeEmolyeeToDatabase(Employee employee) throws SQLException,InvalidContactInfo,InvalidUserDetails{
            ResourceBundle resourceBundleOne=ResourceBundle.getBundle("exceptions");
            basicValidation validation=new basicValidation();
            validation.validateEmployee(employee);

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
            String query1="insert into permenant_address values(?,?,?,?,?,?)";

            preparedStatement= connection.prepareStatement(query1);
            preparedStatement.setString(1,employee.getPermenantAddress().getHouseName());
            preparedStatement.setString(2,employee.getPermenantAddress().getStreetName());
            preparedStatement.setString(3,employee.getPermenantAddress().getCityName());
            preparedStatement.setString(4,employee.getPermenantAddress().getStateName());
            preparedStatement.setInt(5,employee.getPermenantAddress().getPincode());
            preparedStatement.setInt(6,employee.getEmployeeId());
            int recordOne=preparedStatement.executeUpdate();

            String query2="insert into temporary_address values(?,?,?,?,?,?)";
            preparedStatement= connection.prepareStatement(query2);
            preparedStatement.setString(1,employee.getTemporaryAddress().getHouseName());
            preparedStatement.setString(2,employee.getTemporaryAddress().getStreetName());
            preparedStatement.setString(3,employee.getTemporaryAddress().getCityName());
            preparedStatement.setString(4,employee.getTemporaryAddress().getStateName());
            preparedStatement.setInt(5,employee.getTemporaryAddress().getPincode());
            preparedStatement.setInt(6,employee.getEmployeeId());
            int recordTwo=preparedStatement.executeUpdate();
            if(record!=0&&recordOne!=0&&recordTwo!=0){
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


    }


    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList=new ArrayList<>();
        try{
            doConnection setConnection=new doConnection();
            Connection connection=setConnection.makeConnection();
            String query="select * from employee_details";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            String queryTwo="select * from permenant_address where employeeid=?";
            PreparedStatement preparedStatementTwo=connection.prepareStatement(queryTwo);
            String queryThree="select * from temporary_address where employeeid=?";
            PreparedStatement preparedStatementThree=connection.prepareStatement(queryThree);
            ResultSet resultSetTwo;
            ResultSet resultSetOne;
            ResultSet resultSet=preparedStatement.executeQuery();
            if(!resultSet.next()){
                throw new NoEmployeeData();
            }
            while(resultSet.next()){
                Employee employee=new Employee();
                Address permenantAddress=new Address();
                Address temporaryAddress=new Address();
                preparedStatementTwo.setString(1, String.valueOf(resultSet.getInt(5)));
                resultSetOne=preparedStatementTwo.executeQuery();
                if(resultSetOne.next()) {
                    permenantAddress.setHouseName(resultSetOne.getString(1));
                    permenantAddress.setStreetName(resultSetOne.getString(2));
                    permenantAddress.setCityName(resultSetOne.getString(3));
                    permenantAddress.setStateName(resultSetOne.getString(4));
                    permenantAddress.setPincode(resultSetOne.getInt(5));
                   // permenantAddress.set(resultSetOne.getInt(6));
                }
                preparedStatementThree.setString(1,String.valueOf(resultSet.getInt(5)));
                resultSetTwo=preparedStatementThree.executeQuery();
                if(resultSetTwo.next()) {
                    temporaryAddress.setHouseName(resultSetTwo.getString(1));
                    temporaryAddress.setStreetName(resultSetTwo.getString(2));
                    temporaryAddress.setCityName(resultSetTwo.getString(3));
                    temporaryAddress.setStateName(resultSetTwo.getString(4));
                    temporaryAddress.setPincode(resultSetTwo.getInt(5));
                   // temporaryAddress.setPincode(resultSetTwo.getInt(6));
                }
                employee.setFirstName(resultSet.getString(1));
                employee.setMiddeName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmployeePhone(resultSet.getLong(4));
                employee.setEmployeeId(resultSet.getInt(5));
                employee.setEmail(resultSet.getString(6));
                employee.setPermenantAddress(permenantAddress);
                employee.setTemporaryAddress(temporaryAddress);
                employeeList.add(employee);


            }
            preparedStatement.close();
            preparedStatementTwo.close();
            preparedStatementThree.close();
            connection.close();
            resultSet.close();


        }catch (ConnectionException exp) {
        throw new ConnectionException();
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
            String query="SELECT * FROM employee_details emp INNER JOIN permenant_address permadd ON emp.employeeid = permadd.employeeId INNER JOIN temporary_address tempadd ON emp.employeeid = tempadd.employeeid  WHERE tempadd.column3 =?  or permadd.pincode1 = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, pincode);
            preparedStatement.setInt(2, pincode);
            Employee employee=new Employee();
            Address permenantAddress=new Address();
            Address temporaryAddress=new Address();
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                employee.setFirstName(resultSet.getString(1));
                employee.setMiddeName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmployeePhone(resultSet.getLong(4));
                employee.setEmployeeId(resultSet.getInt(5));
                employee.setEmail(resultSet.getString(6));
                permenantAddress.setHouseName(resultSet.getString(7));
                permenantAddress.setStreetName(resultSet.getString(8));
                permenantAddress.setCityName(resultSet.getString(9));
                permenantAddress.setStateName(resultSet.getString(10));
                permenantAddress.setPincode(resultSet.getInt(11));
                temporaryAddress.setHouseName(resultSet.getString(13));
                temporaryAddress.setStreetName(resultSet.getString(14));
                temporaryAddress.setCityName(resultSet.getString(15));
                temporaryAddress.setStateName(resultSet.getString(16));
                temporaryAddress.setPincode(resultSet.getInt(17));
                employee.setPermenantAddress(permenantAddress);
                employee.setTemporaryAddress(temporaryAddress);
                employeeList.add(employee);
            }
            preparedStatement.close();
            connection.close();
            resultSet.close();
            return employeeList;


        }catch (ConnectionException | SQLException exp){
            throw new ConnectionException();
        }
    }

}

