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
        List<Employee> employeeList=new ArrayList<>();
        try{
            doConnection setConnection=new doConnection();
            Connection connection=setConnection.makeConnection();
            String query="select * from employee_details";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            String queryTwo="select * from EMPLOYEE_ADDRESS where EMPLOYEE_ID=?";
            PreparedStatement preparedStatementTwo=connection.prepareStatement(queryTwo);
            ResultSet resultSetOne;
            ResultSet resultSet=preparedStatement.executeQuery();
            if(!resultSet.next()){
                throw new NoEmployeeData();
            }
           do{
                Employee employee=new Employee();
                Address permenantAddress=new Address();
                Address temporaryAddress=new Address();
                preparedStatementTwo.setString(1, String.valueOf(resultSet.getInt(5)));
                resultSetOne=preparedStatementTwo.executeQuery();
                if(resultSetOne.next()) {
                    permenantAddress.setHouseName(resultSetOne.getString(2));
                    permenantAddress.setStreetName(resultSetOne.getString(3));
                    permenantAddress.setCityName(resultSetOne.getString(4));
                    permenantAddress.setStateName(resultSetOne.getString(5));
                    permenantAddress.setPincode(resultSetOne.getInt(6));
                    temporaryAddress.setHouseName(resultSetOne.getString(7));
                    temporaryAddress.setStreetName(resultSetOne.getString(8));
                    temporaryAddress.setCityName(resultSetOne.getString(9));
                    temporaryAddress.setStateName(resultSetOne.getString(10));
                    temporaryAddress.setPincode(resultSetOne.getInt(11));
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

            } while(resultSet.next());
            preparedStatement.close();
            preparedStatementTwo.close();
            connection.close();
            resultSet.close();
            logger.info(resourceBundle.getString("display.employee"));

        }//
        // catch (ConnectionException exp) {
//        throw new ConnectionException();
//    }
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
            String query="select e.firstname,e.employeeid,a.permanent_housename,a.permanent_streetname,a.permanent_city,a.permanent_state,a.permanent_pincode, a.temporary_housename,a.temporary_streetname,a.temporary_city,a.temporary_state,a.temporary_pincode from employee_details e join employee_address a on e.employeeid=a.employee_id where a.permanent_pincode=? or a.temporary_pincode=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, pincode);
            preparedStatement.setInt(2, pincode);
            ResultSet resultSet=preparedStatement.executeQuery();
            do{
                if(resultSet.next()) {
                    Employee employee = new Employee();
                    Address permenantAddress = new Address();
                    Address temporaryAddress = new Address();
                    employee.setFirstName(resultSet.getString(1));
                    employee.setEmployeeId(resultSet.getInt(2));
//                    employee.setMiddeName("trry");
//                    employee.setLastName("try");
//                    employee.setEmployeePhone(545L);
//                    employee.setEmail("aka@gmail.com");
//                    permenantAddress.setHouseName(resultSet.getString(3));
                    permenantAddress.setStreetName(resultSet.getString(4));
                    permenantAddress.setCityName(resultSet.getString(5));
                    permenantAddress.setStateName(resultSet.getString(6));
                    permenantAddress.setPincode(resultSet.getInt(7));
                    temporaryAddress.setHouseName(resultSet.getString(8));
                    temporaryAddress.setStreetName(resultSet.getString(9));
                    temporaryAddress.setCityName(resultSet.getString(10));
                    temporaryAddress.setStateName(resultSet.getString(11));
                    temporaryAddress.setPincode(resultSet.getInt(12));
                    employee.setPermenantAddress(permenantAddress);
                    employee.setTemporaryAddress(temporaryAddress);
                    employeeList.add(employee);
                }
            }while(resultSet.next());
            preparedStatement.close();
            connection.close();
            resultSet.close();
            return employeeList;
        }catch (ConnectionException | SQLException exp){
            //throw new ConnectionException();
            System.out.println(exp);
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

