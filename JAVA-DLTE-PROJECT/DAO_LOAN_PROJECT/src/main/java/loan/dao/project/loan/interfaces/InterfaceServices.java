package loan.dao.project.loan.interfaces;

import loan.dao.project.loan.entities.LoanAvailable;

import java.util.List;

public interface InterfaceServices {
    public List<LoanAvailable> allAvailableLoan();
    public List<LoanAvailable> findByLoanType(String loanType);

}
