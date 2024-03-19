package employee.implement;

import employee.implement.entites.Address;
import employee.implement.entites.Employee;
import employee.implement.exceptions.EmployeeExists;
import employee.implement.exceptions.connectionException;
import employee.implement.exceptions.NoEmployeeData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeDb implements EmployeeInterface {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("informations");

    @Override
    public String writeEmolyeeToDatabase(Employee employee) throws SQLException{
            ResourceBundle resourceBundleOne=ResourceBundle.getBundle("exceptions");

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
                preparedStatement.close();
                connection.close();
                return "EXC000";
            }
            preparedStatement.close();
            connection.close();
            return "EXC001";
        }catch (connectionException exp) {
                throw new connectionException();
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
            resultSet.close();


        }catch (connectionException exp) {
        throw new connectionException();
    }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }
}

