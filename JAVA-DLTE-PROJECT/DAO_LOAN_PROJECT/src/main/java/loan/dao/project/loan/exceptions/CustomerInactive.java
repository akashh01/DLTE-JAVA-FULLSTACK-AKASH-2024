package loan.dao.project.loan.exceptions;

public class CustomerInactive extends RuntimeException {
    public CustomerInactive(String message) {
        super(message);
    }
}
