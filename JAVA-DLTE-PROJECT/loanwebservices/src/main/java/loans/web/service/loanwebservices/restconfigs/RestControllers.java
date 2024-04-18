package loans.web.service.loanwebservices.restconfigs;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.exceptions.CustomerInactive;
import loan.dao.project.loan.exceptions.LoanAlreadyExist;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import loan.dao.project.loan.services.CustomerAuthServices;
import loan.dao.project.loan.services.LoanServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
//api doc http://localhost:8088/v3/api-docs
@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/mybank/loan")
@ComponentScan("loan.dao.project.loan")
@CrossOrigin(origins = "*")
public class RestControllers {
    @Autowired
    CustomerAuthServices services;

    @Autowired
    public LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");
    Logger logger = LoggerFactory.getLogger(LoanServices.class);


    @Operation(summary = "Apply for a loan")
    @PostMapping("/apply")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Loan added successfully"),
            @ApiResponse(responseCode = "409", description = "Loan already exists for the customer"),
            @ApiResponse(responseCode = "204", description = "No loan data exists"),
            @ApiResponse(responseCode = "403", description = "Customer is inactive"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Object> availLoanApi(@Valid @RequestBody LoanAvailed loanAvailRequest) {
        String info = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Extract username from authentication object
        String username = authentication.getName();
        Customer customer=services.findByUserName(username);
        logger.info(username);
        try {
            loanAvailRequest.setCustomerNumber(customer.getCustomerId());
            info = interfaceServices.createNewLoan(loanAvailRequest);
            //SUCCESSS
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
    //FOR BEAN VALIDATION
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
