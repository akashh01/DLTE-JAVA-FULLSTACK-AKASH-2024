package employee.implement.exceptions;

import java.util.ResourceBundle;

public class connectionException extends RuntimeException {
    public connectionException() {
        super(ResourceBundle.getBundle("information").getString("no.data"));
    }
}
