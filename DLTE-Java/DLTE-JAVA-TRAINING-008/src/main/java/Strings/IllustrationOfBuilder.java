package Strings;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IllustrationOfBuilder {
    public static void main(String[] args) {
        StringBuilder  builder=new StringBuilder("Razak m s ");
        //string builder creates mutable string
        //string buffer append method can only be called by one thread at a time
        builder.append(32);
        builder.append(" Java is fun");
        builder.append(11);
        System.out.println(builder);
        builder.insert(15,"-");
        System.out.println(builder);
        builder.replace(25,27,"!!");
        System.out.println(builder);
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        String message=resourceBundle.getString("card.menu");
       // Logger logger=
        System.out.println(message);
       Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO,resourceBundle.getString("card.menu"));
    }
}
