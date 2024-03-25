package employee.implement.validation;

import employee.implement.App;
import employee.implement.entites.Employee;
import employee.implement.exceptions.InvalidContactInfo;
import employee.implement.exceptions.InvalidUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class basicValidation {
    static ResourceBundle resourceBundle=ResourceBundle.getBundle("informations");
    private static Logger logger= LoggerFactory.getLogger(App.class);
    public void validateEmployee(Employee employee){
        if(!validateEmail(employee.getEmail())){
            logger.info(resourceBundle.getString("validation.email"));
            throw new InvalidContactInfo("email ");
        }
        if(!validatePhone(employee.getEmployeePhone())) {
            logger.info(resourceBundle.getString("validation.phone"));
            throw new InvalidContactInfo("phone number");
        }
        if(!validateEmployeeId(employee.getEmployeeId())){
            logger.info(resourceBundle.getString("validation.id"));
            throw new InvalidContactInfo("Employee-id");
        }
        if(!validateName(employee.getFirstName())||!validateName(employee.getMiddeName())||!validateName(employee.getLastName()) ){
            logger.info(resourceBundle.getString("validation.name"));
            throw new InvalidUserDetails("Name");
        }
        if(!validateAdress(employee.getPermenantAddress().getHouseName())){
            logger.info(resourceBundle.getString("validation.house"));
            throw new InvalidUserDetails("House name");
        }
        if(!validateAdress(employee.getPermenantAddress().getCityName())){
            logger.info(resourceBundle.getString("validation.city"));
            throw new InvalidUserDetails("City name");
        }
        if(!validateAdress(employee.getPermenantAddress().getStateName())){
            logger.info(resourceBundle.getString("validation.state"));
            throw new InvalidUserDetails("State name");
        }
        if(!validateAdress(employee.getPermenantAddress().getStreetName())){
            logger.info(resourceBundle.getString("validation.street"));
            throw new InvalidUserDetails("Street name");
        }
        if(!validatePincode(employee.getPermenantAddress().getPincode()))
        {
            logger.info(resourceBundle.getString("validation.pin"));
            throw new InvalidUserDetails("Pincode");
        }
        logger.info(resourceBundle.getString("validation.done"));
    }

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
           // logger.info(resourceBundle.getString("email.validation"));
            return true;
        } else {
            //logger.info(resourceBundle.getString("email.not.validated"));
            return false;
        }
    }
    //validate phone number
    public boolean validatePhone(Long phone){
        String phoneRegex = "^[0-9]{10}";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone.toString());
        if (matcher.matches()) {
         //   logger.info(resourceBundle.getString("phone.validation"));
            return true;

        } else {
           // logger.info(resourceBundle.getString("phone.not.validated"));
            return false;
        }

    }
    public boolean validatePincode(int pin){
        String pinRegex = "^[0-9]{6}";
        Pattern pattern = Pattern.compile(pinRegex);
        Matcher matcher = pattern.matcher(String.valueOf(pin));
        if (matcher.matches()) {
            //logger.info(resourceBundle.getString("pin.validated"));
            return true;

        } else {
            //logger.info(resourceBundle.getString("pin.not.validated"));
            return false;
        }
    }
    public boolean validateEmployeeId(int empId){
        String empIdRegex = "^[0-9]{4}";
        Pattern pattern = Pattern.compile(empIdRegex);
        Matcher matcher = pattern.matcher(String.valueOf(empId));
        if (matcher.matches()) {
            //logger.info(resourceBundle.getString("pin.validated"));
            return true;

        } else {
            //logger.info(resourceBundle.getString("pin.not.validated"));
            return false;
        }
    }
}
