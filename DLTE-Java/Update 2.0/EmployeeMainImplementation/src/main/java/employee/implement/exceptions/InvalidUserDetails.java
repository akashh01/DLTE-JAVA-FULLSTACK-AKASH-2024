package employee.implement.exceptions;

import java.util.ResourceBundle;

public class InvalidUserDetails extends RuntimeException {
    public InvalidUserDetails(String information) {
        super(information+ ResourceBundle.getBundle("informations").getString("info.wrong"));
    }
}

