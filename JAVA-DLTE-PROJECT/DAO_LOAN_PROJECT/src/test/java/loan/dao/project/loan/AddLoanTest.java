//package loan.dao.project.loan;
//
//import loan.dao.project.loan.entities.LoanAvailed;
//import loan.dao.project.loan.exceptions.LoanAlreadyExist;
//import loan.dao.project.loan.services.LoanServices;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.CallableStatementCreator;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ResourceBundle;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//public class AddLoanTest {
//
//    @Mock
//    public JdbcTemplate jdbcTemplate;
//    @InjectMocks
//    public LoanServices loanServices;
//
//    @Test
//    public void testCreateNewLoan() {
//        LoanAvailed loan = new LoanAvailed();
//        loan.setCustomerNumber(1);
//        loan.setLoanNumber(123456789L);
//        loan.setLoanAmount(50000L);
//        loan.setLoanEmi(5000.0);
//        loan.setLoanTenure(12);
//
//        Map<String, Object> returnedExecution = new HashMap<>();
//        returnedExecution.put("errOrInfo", "SQE001");
//
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
//        Mockito.when(resourceBundle.getString("loan.exists.customer")).thenReturn("Loan already exists for the customer");
//
//       // Mockito.when(jdbcTemplate.call(any(CallableStatementCreator.class), any(List.class))).thenReturn(returnedExecution);
//
//        // Inject mocked dependencies
//
//        // Act and Assert
//        Exception exception = assertThrows(LoanAlreadyExist.class, () -> {
//            loanServices.createNewLoan(loan);
//        });
//
//        String expectedMessage = "Loan already exists for the customer";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//}
