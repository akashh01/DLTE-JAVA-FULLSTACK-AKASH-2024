package loan.dao.project.loan.interfaces;

import loan.dao.project.loan.entities.LoanAvailable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoanInterface {
    public List<LoanAvailable> allAvailableLoan();
    public List<LoanAvailable> findByLoanType(String loanType);

}
