package autowire.spring.task.autowire;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//fetching all the home loans
@Component("homeLoan")
public class HomeLoan implements LoanInterface {
    @Override
    public List<Loan> findALL() {
        List<Loan> newList=new ArrayList<>();
        for (Loan each:loansList) {
            if (each.getLoanType().equals("Home")){
                newList.add(each);
            }

        }
        return newList;
    }
}
