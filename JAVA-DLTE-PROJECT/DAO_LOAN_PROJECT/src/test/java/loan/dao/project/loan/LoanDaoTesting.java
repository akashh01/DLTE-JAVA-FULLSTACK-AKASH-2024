package loan.dao.project.loan;


import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.services.LoanServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LoanDaoTesting {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private LoanServices loanServices;

    @Test
    void allAvailableLoan_Success() {
        // Mocking the response from the database
        List<LoanAvailable> mockLoanList = new ArrayList<>();
        mockLoanList.add(new LoanAvailable(1800, "Personal Loan", "My personal loan", "mock personal loan", 10.0));
        mockLoanList.add(new LoanAvailable(2000, "Gold Loan", "My bank loan", "mock description loan", 20.0));
        when(jdbcTemplate.query(anyString(), any(LoanServices.LoanAvailableMapper.class))).thenReturn(mockLoanList);

        // Calling the method under test
        List<LoanAvailable> result = loanServices.allAvailableLoan();
        //pass
        assertEquals(2, result.size());
        //pass
        assertEquals("Personal Loan", result.get(0).getLoanType());
        //fail
        assertEquals("No loan", result.get(1).getLoanName());
    }

    @Test
    void allAvailableLoan_NoDataFound() {
        // Mocking an empty response from the database
        when(jdbcTemplate.query(anyString(), any(LoanServices.LoanAvailableMapper.class))).thenReturn(new ArrayList<>());

        // Calling the method under test and expecting an exception
        assertThrows(NoLoanData.class, () -> loanServices.allAvailableLoan());
    }

}



