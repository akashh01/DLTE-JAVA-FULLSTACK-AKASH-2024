package loans.web.service.loanwebservices.restconfigs;


import io.swagger.v3.oas.annotations.Operation;
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
//api doc http://localhost:8088/v3/api-docs
@RestController
@RequestMapping("/mybank/loan")
@ComponentScan("loan.dao.project.loan")
@CrossOrigin(origins = "*")
public class RestControllers {
    @Autowired
    public LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");
    Logger logger = LoggerFactory.getLogger(LoanServices.class);

    @Operation(summary = "Apply for a loan")
    @PostMapping("/apply")
    public ResponseEntity<Object> availLoanApi(@Valid @RequestBody LoanAvailed loanAvailRequest) {
        String info = "";
        try {
            info = interfaceServices.createNewLoan(loanAvailRequest);
            //myBankRemo.availDeposits(depositsAvailRequest);
            logger.info(resourceBundle.getString("post.success"));
            return ResponseEntity.ok(resourceBundle.getString("loan.added.sucess"));
        } catch (LoanAlreadyExist exception) {
            logger.info(exception.toString());
            return new ResponseEntity<>(resourceBundle.getString("loan.exists.customer"), HttpStatus.CONFLICT);
        } catch (NoLoanData exception) {
            logger.info(exception.toString());
            return new ResponseEntity<>(resourceBundle.getString("loan.not.exists"), HttpStatus.NO_CONTENT);
        } catch (CustomerInactive exception) {
            logger.info(exception.toString());
            return new ResponseEntity<>(resourceBundle.getString("loan.user.inactive"), HttpStatus.FORBIDDEN);
        } catch (LoanServiceException exception) {
            logger.info(exception.toString());
            return new ResponseEntity<>(resourceBundle.getString("loan.user.inactive"), HttpStatus.INTERNAL_SERVER_ERROR);
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
