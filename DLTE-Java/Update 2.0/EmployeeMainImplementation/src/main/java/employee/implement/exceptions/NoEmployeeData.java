package employee.implement.exceptions;

import java.util.ResourceBundle;

public class NoEmployeeData extends RuntimeException{
    public NoEmployeeData() {
        super(ResourceBundle.getBundle("information").getString("no.data"));
    }
}