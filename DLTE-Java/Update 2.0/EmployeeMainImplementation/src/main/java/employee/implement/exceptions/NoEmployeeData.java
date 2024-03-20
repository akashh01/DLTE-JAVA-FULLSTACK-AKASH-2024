package employee.implement.exceptions;

import java.util.ResourceBundle;

public class NoEmployeeData extends RuntimeException{
    public NoEmployeeData() {
        super(ResourceBundle.getBundle("informations").getString("no.data"));
    }
}