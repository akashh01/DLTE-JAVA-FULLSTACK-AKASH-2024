package loan.dao.project.loan.exceptions;

public class LoanAlreadyExist extends RuntimeException {
    public LoanAlreadyExist(String message)
        {
            super(message);
        }
    }

