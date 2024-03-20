package example.task.contollertask;

import org.apache.el.stream.Stream;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanContoller {
      private List<Loan> loanList= new ArrayList<>();
      public LoanContoller(){
          loanList.add(new Loan(1244448L,500L,"open","Akash",44544888988L));
          loanList.add(new Loan(1244449L,10000L,"open","Akshira",445448444456L));

      }
      @GetMapping("/{index}")
    public Loan findLoan(@PathVariable int index){
          return loanList.get(index);
      }
      @PostMapping("/loanAdd")
    public Loan addLoan(@RequestBody Loan loan){
          loanList.add(loan);
          return loan;
      }


}
