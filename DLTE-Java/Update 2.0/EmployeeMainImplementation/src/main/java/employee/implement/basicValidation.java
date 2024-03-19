package employee.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class basicValidation {
    static ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
    private static Logger logger= LoggerFactory.getLogger(App.class);
    public boolean validateName(String anyName){
        String nameRegex = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(anyName);
        if (matcher.matches()) {
            // logger.info(resourceBundle.getString("email.validation"));
            return true;
        } else {
            //logger.info(resourceBundle.getString("email.not.validated"));
            return false;
        }
    }
    public boolean validateAdress(String data){
        if(data.length()!=0){
            return true;
        }
        else{
            return false;
        }

    }


    public boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+-_]{3,}@[A-Za-z]{3,}(.)[A-Za-z]{2,}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            logger.info(resourceBundle.getString("email.validation"));
            return true;
        } else {
            logger.info(resourceBundle.getString("email.not.validated"));
            return false;
        }
    }
    //validate phone number
    public boolean validatePhone(Long phone){
        String phoneRegex = "^[0-9]{10}";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone.toString());
        if (matcher.matches()) {
            logger.info(resourceBundle.getString("phone.validation"));
            return true;

        } else {
            logger.info(resourceBundle.getString("phone.not.validated"));
            return false;
        }

    }
    public boolean validatePincode(int pin){
        String pinRegex = "^[0-9]{6}";
        Pattern pattern = Pattern.compile(pinRegex);
        Matcher matcher = pattern.matcher(String.valueOf(pin));
        if (matcher.matches()) {
            logger.info(resourceBundle.getString("pin.validated"));
            return true;

        } else {
            logger.info(resourceBundle.getString("pin.not.validated"));
            return false;
        }
    }
}
