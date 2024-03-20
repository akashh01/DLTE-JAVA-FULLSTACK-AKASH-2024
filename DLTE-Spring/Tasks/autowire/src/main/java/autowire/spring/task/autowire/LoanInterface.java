package autowire.spring.task.autowire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface LoanInterface {
    List<Loan> loansList= Stream.of(new Loan(44545645L,5000L,"open","Home","Akash",4545454545L),new Loan(445454545L,5000L,"open","Personal","Ashok",4545454545L),new Loan(4559820231L,6000L,"open","home","Ajay",4545454545L)).collect(Collectors.toList());
    List<Loan> findALL();
}
