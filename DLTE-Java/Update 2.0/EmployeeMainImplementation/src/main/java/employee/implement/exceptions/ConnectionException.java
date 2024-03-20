package employee.implement.exceptions;

import java.util.ResourceBundle;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
        super(ResourceBundle.getBundle("information").getString("no.data"));
    }
}
