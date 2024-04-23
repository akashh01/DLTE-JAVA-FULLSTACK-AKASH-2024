package loan.dao.project.loan;

import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.exceptions.LoanAlreadyExist;
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

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AddLoanTest {

    @Mock
    public JdbcTemplate jdbcTemplate;
    @InjectMocks
    public LoanServices service;

    @Test
    void testCreateNewLoan_Success() {
        LoanAvailed loanAvailed = new LoanAvailed(1, 1000001L, 10000L, 400.0, 1); // Instantiate your entity

        // Mock the behavior of jdbcTemplate.call
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errOrInfo", "Success");
        Mockito.when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(resultMap);

        // Call the method to be tested
        String result = service.createNewLoan(loanAvailed);

        // Assert the result
        assertEquals("Success", result);
    }
    @Test
    void testCreateNewLoan_Failure() {


        LoanAvailed loanAvailed = new LoanAvailed(1, 1000001L, 10000L, 400.0, 1); // Instantiate your entity

        // Mock the behavior of jdbcTemplate.call
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errOrInfo", "SQE001"); // Mocking a failure
        Mockito.when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(resultMap);

        // Call the method to be tested and assert that it throws the expected exception
        assertThrows(LoanAlreadyExist.class, () -> service.createNewLoan(loanAvailed));
    }


}
