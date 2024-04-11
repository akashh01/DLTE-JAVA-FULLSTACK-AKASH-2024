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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<Object> availLoanApi(@Valid @RequestBody LoanAvailed loanAvailRequest){
       String info="";
        try{
            info=interfaceServices.createNewLoan(loanAvailRequest);
            //myBankRemo.availDeposits(depositsAvailRequest);
            logger.info(resourceBundle.getString("post.success"));
            return ResponseEntity.ok(resourceBundle.getString("loan.added.sucess"));
        }
        catch (LoanAlreadyExist exception){
            logger.info(exception.toString());
            return new ResponseEntity<>(resourceBundle.getString("loan.exists.customer"),HttpStatus.BAD_REQUEST);
        }
        catch (NoLoanData exception){
            logger.info(exception.toString());
            return new ResponseEntity<>(resourceBundle.getString("loan.not.exists"),HttpStatus.BAD_REQUEST);
        }
        catch (CustomerInactive exception){
            logger.info(exception.toString());
            return new ResponseEntity<>(resourceBundle.getString("loan.user.inactive"),HttpStatus.BAD_REQUEST);
        }
       catch (LoanServiceException exception){
           logger.info(exception.toString());
           return new ResponseEntity<>(resourceBundle.getString("loan.user.inactive"),HttpStatus.BAD_REQUEST);
       }


    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



}
