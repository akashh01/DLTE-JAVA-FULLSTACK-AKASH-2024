package autowire.spring.task.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
//injection by autowirign homeloan into interface
@Service
public class MyBank {
    @Autowired
    @Qualifier("homeLoan")
    private LoanInterface loanInterface;
    public List<Loan> callFindAll(){
        List<Loan> injectedLoan=loanInterface.findALL();
        return injectedLoan;
    }

}
