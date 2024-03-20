package employee.implement.exceptions;

import java.util.ResourceBundle;

public class InvalidContactInfo extends RuntimeException {
    public InvalidContactInfo(String information) {
        super(information+ ResourceBundle.getBundle("informations").getString("info.wrong"));
    }
}
