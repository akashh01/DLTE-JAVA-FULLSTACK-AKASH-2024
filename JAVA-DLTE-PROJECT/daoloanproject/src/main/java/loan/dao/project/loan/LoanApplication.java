package loan.dao.project.loan;

import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.interfaces.LoanInterface;
import loan.dao.project.loan.services.LoanServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class LoanApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LoanApplication.class, args);
        LoanServices loanServices = context.getBean(LoanServices.class);
//        List<LoanAvailable> check = loanServices.allAvailableLoan();
//        LoanAvailed loan = new LoanAvailed(101, 121L, 5000L, 3.5, 6);
//        String info = loanServices.createNewLoan(loan);
//        System.out.println(info);
//        System.out.println(check);

    }

}
