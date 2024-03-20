package autowire.spring.task.autowire;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//fetching all the personal loans
@Component("personalLoan")
public class PersonalLoan implements LoanInterface {
    @Override
    public List<Loan> findALL() {
        List<Loan> newList=new ArrayList<>();
        for (Loan each:loansList) {
            if (each.getLoanType().equals("Personal")){
                newList.add(each);
            }

        }
        return newList;
    }
}


