package loan.dao.project.loan.interfaces;

import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.entities.LoanAvailed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanInterface {
    public List<LoanAvailable> allAvailableLoan();


    public String createNewLoan(LoanAvailed loan);

}
