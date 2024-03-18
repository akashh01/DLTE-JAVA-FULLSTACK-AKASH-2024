package application.db.Middlewares;

import application.db.Entities.Customer;
import application.db.Exception.UserNotFoundException;
import application.db.Remotes.UserInfoRepository;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class UserInfoDatabaseRepository implements UserInfoRepository {
    private Connection connection;
    private ArrayList<Customer> userList=new ArrayList<>();
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
    private Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private PreparedStatement preparedStatement;
    private PreparedStatement preparedStatementTwo;
    private PreparedStatement preparedStatementThree;
    private ResultSet resultSet;

    public UserInfoDatabaseRepository(Connection connection){
        try{
            this.connection = connection;
            FileHandler fileHandler=new FileHandler("credit-card-logs.txt",true);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    @Override
    public boolean validateUser(String username) {
        boolean flag =false;
        try {
            String query = "select * from user_info where username=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                flag=true;
                System.out.println(resourceBundle.getString("user.valid"));
                return flag;
            }
            else {
                System.out.println(resourceBundle.getString("user.name"));
            }
        }catch(SQLException sqlException){
            System.out.println(sqlException);
        }
        return flag;

    }

    @Override
    public void DepositAmountInto(String username, Long amount) {
        try {
            String query = "select initialbalance from user_info where username=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            Long initialAmount=0L;
            if(resultSet.next()) {
                 initialAmount= Long.valueOf((resultSet.getString("initialbalance")));
                System.out.println(initialAmount);
            }
            Long newAmount=initialAmount+amount;
            String updateQuery="update user_info set initialbalance=? where username=?";
            preparedStatementThree=connection.prepareStatement(updateQuery);
            preparedStatementThree.setString(1, String.valueOf(newAmount));
            preparedStatementThree.setString(2,username);
            int result=preparedStatementThree.executeUpdate();
            if(result!=0){
                System.out.println(" Records are updated");
            }
            else{
                System.out.println(" Records aren't updated");
            }
            String type="deposit";
            String currentDate=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String transactQuery="insert into  TRANSACTION_USER values(?,?,?,?)";
            preparedStatementTwo=connection.prepareStatement(transactQuery);
            preparedStatementTwo.setString(1,username);
            preparedStatementTwo.setString(2,type);
            preparedStatementTwo.setString(3,String.valueOf(amount));
            preparedStatementTwo.setString(4,currentDate);
            int resultSetTwo = preparedStatementTwo.executeUpdate();
            if (resultSetTwo != 0) {
                logger.log(Level.INFO, resourceBundle.getString("db.push.ok"));
                System.out.println(resourceBundle.getString("db.push.ok"));
            } else {
                logger.log(Level.INFO, resourceBundle.getString("db.push.fail"));
                System.out.println(resourceBundle.getString("db.push.fail"));
            }


        }

        catch(SQLException sqlException){
            System.out.println(sqlException);
        }
    }

    @Override
    public void addInformation(Customer customer) {
        try{
          //  String splitTransaction=customer.getTransactionDetails();
            customer.getTransactionDetails().size();
            String query = "insert into  user_info values(?,?,?,?,?,?)";
            String queryTwo = "insert into  TRANSACTION_USER values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,customer.getUsername());
            preparedStatement.setString(2,customer.getPassword());
            preparedStatement.setString(3,customer.getAddress());
            preparedStatement.setString(4,customer.getEmail());
            preparedStatement.setLong(5,customer.getContact());
            preparedStatement.setLong(6,customer.getInitialBalace());
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet != 0) {
                logger.log(Level.INFO, resourceBundle.getString("db.push.ok"));
                System.out.println(resourceBundle.getString("db.push.ok"));
            } else {
                logger.log(Level.INFO, resourceBundle.getString("db.push.fail"));
                System.out.println(resourceBundle.getString("db.push.fail"));
            }

            for(int index=0;index<customer.getTransactionDetails().size();index++){
//                String transaction= (String) customer.getTransactionDetails().get(index);
//                String[] splitTransaction=transaction.split(",");
             //   System.out.println(customer.getTransactionDetails().get(0));
                String transaction= (customer.getTransactionDetails().get(0)).toString();
                String[] splitTransaction=transaction.split(",");
               // System.out.println(splitTransaction[2]);
                //System.out.println();
                preparedStatementTwo = connection.prepareStatement(queryTwo);
                preparedStatementTwo.setString(1,customer.getUsername());
                preparedStatementTwo.setString(2,splitTransaction[0]);
                preparedStatementTwo.setString(3,splitTransaction[1]);
                preparedStatementTwo.setString(4,splitTransaction[2]);
                int resultSetTwo = preparedStatementTwo.executeUpdate();
                if (resultSetTwo != 0) {
                    logger.log(Level.INFO, resourceBundle.getString("db.push.transaction.ok"));
                    System.out.println(resourceBundle.getString("db.push.transaction.ok"));
                } else {
                    logger.log(Level.INFO, resourceBundle.getString("db.transaction.fail"));
                    System.out.println(resourceBundle.getString("db.transaction.fail"));
                }

            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public boolean passwordValidate(String username, String password) {
        //System.out.println(customer.getPassword());
        boolean flag =false;
        //System.out.println("check");
        try {
            String query = "select * from user_info where username=? and password=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                flag=true;
                logger.info(resourceBundle.getString("user.validated"));
                return flag;
            }
        }catch(SQLException sqlException){
            System.out.println(sqlException);
        }
        return flag;

    }

    @Override
    public List findAll() {
        ArrayList<List> transactionArrayList=new ArrayList<>();
        try{
            String query="select * from transaction_user";
            preparedStatement=connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //transactionArrayList.add(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4));
                String user=resultSet.getString(1);
                String type=resultSet.getString(2);
                String amount=resultSet.getString(3);
                String date=resultSet.getString(4);
                StringBuilder builder = new StringBuilder(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+","+resultSet.getString(4));
                transactionArrayList.add(Collections.singletonList(builder));
//        builder.append("," + new Date());
//        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return transactionArrayList;
    }

    @Override
    public List findByUsername(String username) {
        ArrayList<List> transactionArrayList=new ArrayList<>();
        try{
            String query="select * from transaction_user where username=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //transactionArrayList.add(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4));
                StringBuilder builder = new StringBuilder(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+","+resultSet.getString(4));
                transactionArrayList.add(Collections.singletonList(builder));
//        builder.append("," + new Date());
//        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return transactionArrayList;
    }

    @Override
    public List findByDateAndUsername(String username, String date) {
        ArrayList<List> transactionArrayList=new ArrayList<>();
        try{
            String query="select * from transaction_user where username=? and transactiondate=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,date);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                StringBuilder builder = new StringBuilder(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+","+resultSet.getString(4));
                transactionArrayList.add(Collections.singletonList(builder));
//        builder.append("," + new Date());
//        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return transactionArrayList;
    }
    //added for the new rest api

    @Override
    public Customer oneUserDetail(String username) {
        Customer newCustomer=new Customer();
        try{
            String query="select * from user_info where username=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               newCustomer.setUsername(resultSet.getString(1));
               newCustomer.setPassword(resultSet.getString(2));
               newCustomer.setAddress(resultSet.getString(3));
               newCustomer.setEmail(resultSet.getString(4));
               newCustomer.setContact(resultSet.getLong(5));
               newCustomer.setInitialBalace(resultSet.getLong(6));

            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }
        return newCustomer;
    }
}
