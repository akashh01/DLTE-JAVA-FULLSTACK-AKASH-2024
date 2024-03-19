package employee.implement;

import employee.implement.exceptions.connectionException;
import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class doConnection {
    public Connection makeConnection() {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("informations");
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(resourceBundle.getString("db.url"), resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            return connection;
        }catch (connectionException| SQLException con){
            throw new connectionException();
        }

    }

    }


