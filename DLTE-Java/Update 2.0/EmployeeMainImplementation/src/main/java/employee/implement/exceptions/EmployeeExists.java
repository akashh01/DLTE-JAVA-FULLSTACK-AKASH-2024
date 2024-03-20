package employee.implement.exceptions;

import java.util.ResourceBundle;

public class EmployeeExists extends RuntimeException {
    public EmployeeExists(){
            super(ResourceBundle.getBundle("informations").getString("employee.exist"));

    }

}
