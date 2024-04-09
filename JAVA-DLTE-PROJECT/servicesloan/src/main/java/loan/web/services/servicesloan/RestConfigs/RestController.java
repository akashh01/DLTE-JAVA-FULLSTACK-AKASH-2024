package loan.web.services.servicesloan.RestConfigs;


import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.exceptions.CustomerInactive;
import loan.dao.project.loan.exceptions.LoanAlreadyExist;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import loan.dao.project.loan.services.LoanServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ResourceBundle;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/mybank/loan")
@ComponentScan("loan.dao.project.loan")
@CrossOrigin(origins = "*")
public class RestController {
    @Autowired
    public LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    Logger logger= LoggerFactory.getLogger(LoanServices.class);

    @PostMapping("/apply")
    public ResponseEntity<Object> availDepositApi(@Valid @RequestBody LoanAvailed depositsAvailRequest){
       String info="";
        try{
            info=interfaceServices.createNewLoan(depositsAvailRequest);
            //myBankRemo.availDeposits(depositsAvailRequest);
            logger.info("Post Request Successful");
        }
       catch (LoanAlreadyExist| NoLoanData| CustomerInactive| LoanServiceException exp){
           logger.info(exp.toString());
       }
        return ResponseEntity.ok(info);
    }

}
