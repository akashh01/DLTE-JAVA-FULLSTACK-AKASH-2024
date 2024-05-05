package loan.dao.project.loan;

import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.exceptions.CustomerInactive;
import loan.dao.project.loan.exceptions.LoanAlreadyExist;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.services.LoanServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AddLoanTest {



    @Mock
    public JdbcTemplate jdbcTemplate;
    @InjectMocks
    public LoanServices service;

    @Test
    void testCreateNewLoan_Success() {
        LoanAvailed loanAvailed = new LoanAvailed();
        loanAvailed.setLoanAvailNumber(1);
        loanAvailed.setCustomerNumber(1001);
        loanAvailed.setLoanNumber(10000L);
        loanAvailed.setLoanAmount(40000L);
        loanAvailed.setLoanEmi(400.0);
        loanAvailed.setLoanTenure(1);// Instantiate your entity
        // Mock the behavior of jdbcTemplate.call
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errOrInfo", "Success");
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(resultMap);
        String result = service.createNewLoan(loanAvailed);
        // Assert the result
        assertEquals("Success", result);
    }
    @Test
    void testCreateNewLoan_Failure() {
        LoanAvailed loanAvailed = new LoanAvailed();
        loanAvailed.setLoanAvailNumber(1);
        loanAvailed.setCustomerNumber(1000001);
        loanAvailed.setLoanNumber(10000L);
        loanAvailed.setLoanAmount(40000L);
        loanAvailed.setLoanEmi(400.0);
        loanAvailed.setLoanTenure(1);// Instantiate your entity
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errOrInfo", "SQE001"); // Mocking a failure
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(resultMap);
        // Call the method to be tested and assert that it throws the expected exception
        assertThrows(LoanAlreadyExist.class, () -> service.createNewLoan(loanAvailed));
    }
    @Test
    void testCreateNewLoan_CustomerInactive() {
        LoanAvailed loanAvailed = new LoanAvailed(1, 1000001L, 10000L, 400.0, 1);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errOrInfo", "SQE002"); // Mocking a failure
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(resultMap);
        assertThrows(CustomerInactive.class, () -> service.createNewLoan(loanAvailed));
    }

    @Test
    void testCreateNewLoan_NoLoanData() {
        LoanAvailed loanAvailed = new LoanAvailed(1, 1000001L, 10000L, 400.0, 1);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errOrInfo", "SQE003"); // Mocking a failure
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(resultMap);
        assertThrows(NoLoanData.class, () -> service.createNewLoan(loanAvailed));
    }

    @Test
    void testCreateNewLoan_LoanServiceException() {
        LoanAvailed loanAvailed = new LoanAvailed(1, 1000001L, 10000L, 400.0, 1);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errOrInfo", "SQE004"); // Mocking a failure
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(resultMap);
        assertThrows(LoanServiceException.class, () -> service.createNewLoan(loanAvailed));
    }
    @Test
    void testGettersAndSetters() {
        // Create a LoanAvailed object
        LoanAvailed loan = new LoanAvailed();
        // Set values using setters
        loan.setLoanAvailNumber(123);
        loan.setCustomerNumber(456);
        loan.setLoanNumber(789L);
        loan.setLoanAmount(100000L);
        loan.setLoanEmi(5000.0);
        loan.setLoanTenure(24);
        //assertEquals(123, loan.getLoanAvailNumber());
        assertEquals(456, loan.getCustomerNumber());
        assertEquals(789L, loan.getLoanNumber());
        assertEquals(100000L, loan.getLoanAmount());
        assertEquals(5000.0, loan.getLoanEmi());
        assertEquals(24, loan.getLoanTenure());
    }





}
