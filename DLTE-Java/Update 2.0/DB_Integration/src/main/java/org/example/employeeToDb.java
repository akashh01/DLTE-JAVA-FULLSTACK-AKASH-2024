package org.example;

import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class employeeToDb {
//    private Connection connection;
//    private PreparedStatement preparedStatement;
//    private ResultSet resultSet;
   static ResourceBundle resourceBundle=ResourceBundle.getBundle("database");

    public void writeEmployeeToDatabase(String firstname,String middlename,String lastname,Long phone,Integer employeeid,String email){
        Driver driver=new OracleDriver();
       // System.out.println(firstname+id);
        //ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));

            String query="insert into EMPLOYEE_DETAILS values(?,?,?,?,?,?)";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,firstname);
            preparedStatement.setString(2,middlename);
            preparedStatement.setString(3,lastname);
            preparedStatement.setLong(4,phone);
            preparedStatement.setInt(5,employeeid);
            preparedStatement.setString(6,email);

            int records=preparedStatement.executeUpdate();
            if(records!=0){
                System.out.println("Record has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addressToDb(String houseName,String streetName,String cityName,String stateName,Integer pincode,Integer employeeId){
        Driver driver=new OracleDriver();
        // System.out.println(firstname+id);
        //ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));

            String query="insert into permenant_address values(?,?,?,?,?,?)";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,houseName);
            preparedStatement.setString(2,streetName);
            preparedStatement.setString(3,cityName);
            preparedStatement.setString(4,stateName);
            preparedStatement.setInt(5,pincode);
            preparedStatement.setInt(6,employeeId);

            int records=preparedStatement.executeUpdate();
            if(records!=0){
                System.out.println("Record has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void tempAddressToDb(String houseName,String streetName,String cityName,String stateName,Integer pincode,Integer employeeId){
        Driver driver=new OracleDriver();
        // System.out.println(firstname+id);
        //ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        try{
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(resourceBundle.getString("db.url"),resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));

            String query="insert into temporary_address values(?,?,?,?,?,?)";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,houseName);
            preparedStatement.setString(2,streetName);
            preparedStatement.setString(3,cityName);
            preparedStatement.setString(4,stateName);
            preparedStatement.setInt(5,pincode);
            preparedStatement.setInt(6,employeeId);

            int records=preparedStatement.executeUpdate();
            if(records!=0){
                System.out.println("Record has inserted");
            }
            else{
                System.out.println("Record hasn't inserted");
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}

