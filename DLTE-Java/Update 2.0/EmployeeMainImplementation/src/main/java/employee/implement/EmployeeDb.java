package employee.implement;

import employee.implement.entites.Address;
import employee.implement.entites.Employee;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeDb implements EmployeeInterface {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("informations");
    @Override
    public void writeEmolyeeToDatabase(Employee employee) {
        Driver driver=new OracleDriver();
        // System.out.println(firstname+id);
        //ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            String query="insert into EMPLOYEE_DETAILS values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getMiddeName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setLong(4,employee.getEmployeePhone());
            preparedStatement.setInt(5,employee.getEmployeeId());
            preparedStatement.setString(6,employee.getEmail());
            int records=preparedStatement.executeUpdate();
            if(records!=0){
                System.out.println("Record has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    @Override
    public void addressToDb(Address address,int employeeId){
        Driver driver=new oracle.jdbc.OracleDriver();
        // System.out.println(firstname+id);
        //ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            String query="insert into permenant_address values(?,?,?,?,?,?)";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,address.getHouseName());
            preparedStatement.setString(2,address.getStreetName());
            preparedStatement.setString(3,address.getCityName());
            preparedStatement.setString(4,address.getStateName());
            preparedStatement.setInt(5,address.getPincode());
            preparedStatement.setInt(6,employeeId);

            int records=preparedStatement.executeUpdate();
            if(records!=0){
                System.out.println("Record has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    @Override
    public void tempAddressToDb(Address address,int employeeId){
        Driver driver=new oracle.jdbc.OracleDriver();
        // System.out.println(firstname+id);
        //ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            String query="insert into temporary_address values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,address.getHouseName());
            preparedStatement.setString(2,address.getStreetName());
            preparedStatement.setString(3,address.getCityName());
            preparedStatement.setString(4,address.getStateName());
            preparedStatement.setInt(5,address.getPincode());
            preparedStatement.setInt(6,employeeId);
            int records=preparedStatement.executeUpdate();
            if(records!=0){
                System.out.println("Record has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        Driver driver=new OracleDriver();
        List<Employee> employeeList=new ArrayList<>();
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
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
            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }
}

