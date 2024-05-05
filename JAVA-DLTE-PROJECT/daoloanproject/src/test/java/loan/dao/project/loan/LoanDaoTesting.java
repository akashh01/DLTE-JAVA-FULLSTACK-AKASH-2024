package loan.dao.project.loan;


import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.services.LoanServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LoanDaoTesting {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private LoanServices loanServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("loandao");

//    @InjectMocks
//    ValidationConfiguration validationConfiguration;


    @Test
    void allAvailableLoan_Success() {
        // Mocking the response from the database
        LoanAvailable loan1 = new LoanAvailable();
        loan1.setLoanNumber(1800);
        loan1.setLoanType("Personal Loan");
        loan1.setLoanName("My personal loan");
        loan1.setLoanDescription("mock personal loan");
        loan1.setLoanRoi(10.0);

        LoanAvailable loan2 = new LoanAvailable();
        loan2.setLoanNumber(2000);
        loan2.setLoanType("Gold Loan");
        loan2.setLoanName("My bank loan");
        loan2.setLoanDescription("mock description loan");
        loan2.setLoanRoi(20.0);

        List<LoanAvailable> mockLoanList = new ArrayList<>();
        mockLoanList.add(loan1);
        mockLoanList.add(loan2);

        when(jdbcTemplate.query(anyString(), any(LoanServices.LoanAvailableMapper.class))).thenReturn(mockLoanList);

        // Calling the method under test
        List<LoanAvailable> result = loanServices.allAvailableLoan();
        //pass
        assertEquals(2, result.size());
        //pass
        assertEquals("Personal Loan", result.get(0).getLoanType());
        //fail
        assertNotEquals("No loan", result.get(1).getLoanName());
    }

    @Test
    void allAvailableLoanNoDataFound() {
        // Mocking an empty response from the database
        when(jdbcTemplate.query(anyString(), any(LoanServices.LoanAvailableMapper.class))).thenReturn(new ArrayList<>());
        // Calling the method under test and expecting an exception
        assertThrows(NoLoanData.class, () -> loanServices.allAvailableLoan());
    }
    @Test
    void testAllAvailableLoan_DatabaseError() {
        // database error
        when(jdbcTemplate.query(anyString(), any(LoanServices.LoanAvailableMapper.class))).thenThrow(new DataAccessException("Database error") {});
        Throwable exception = assertThrows(LoanServiceException.class, () -> {
            loanServices.allAvailableLoan();
        });
        // Asserting that the method throws the expected exception
        assertEquals(resourceBundle.getString("no.service.exp"), exception.getMessage());
    }

    @Test
    public void testLoanAvailableMapper() throws SQLException {
        // Create a mock ResultSet
        ResultSet rs = Mockito.mock(ResultSet.class);
        Mockito.when(rs.getInt(1)).thenReturn(123);
        Mockito.when(rs.getString(2)).thenReturn("Personal");
        Mockito.when(rs.getString(3)).thenReturn("Apna loan"); // Loan name
        Mockito.when(rs.getString(4)).thenReturn("Best loan");
        Mockito.when(rs.getDouble(5)).thenReturn(5.5);
        LoanServices.LoanAvailableMapper mapper = new LoanServices.LoanAvailableMapper();

        LoanAvailable loanAvailable = mapper.mapRow(rs, 1);
        assertEquals(123, loanAvailable.getLoanNumber());
        assertEquals("Personal", loanAvailable.getLoanType());
        assertEquals("Apna loan", loanAvailable.getLoanName());
        assertEquals("Best loan", loanAvailable.getLoanDescription());
        assertEquals(5.5, loanAvailable.getLoanRoi());
    }


}



