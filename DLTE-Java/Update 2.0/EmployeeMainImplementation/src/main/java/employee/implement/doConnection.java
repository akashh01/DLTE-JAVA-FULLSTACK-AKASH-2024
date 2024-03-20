package employee.implement;

import employee.implement.exceptions.ConnectionException;
import oracle.jdbc.driver.OracleDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class doConnection {
    public Connection makeConnection() {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("informations");
        Logger logger= LoggerFactory.getLogger(App.class);
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(resourceBundle.getString("db.url"), resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            return connection;
        }catch (ConnectionException | SQLException con){
          logger.info(resourceBundle.getString("connection.failed"));
            throw new ConnectionException();
        }

    }

    }


