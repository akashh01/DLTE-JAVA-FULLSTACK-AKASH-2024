package loan.web.services.servicesloan;


import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import loan.web.services.servicesloan.configs.LoanPhase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import services.loans.ViewAllAvailableLoanRequest;
import services.loans.ViewAllAvailableLoanResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServicesloanApplicationTests{

        @Autowired
        private LoanPhase loanPhase;

        @MockBean
        private LoanInterface interfaceServices;

        @Test
        public void testViewAvailLoanRequest_Success() {
            // Arrange
            ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
            List<LoanAvailable> mockLoanList = new ArrayList<>();

            mockLoanList.add(new LoanAvailable());
            when(interfaceServices.allAvailableLoan()).thenReturn(mockLoanList);

            // Act
            ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);

            // Assert
            assertNotNull(response);
            assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
            assertNotNull(response.getLoanAvailable());
            assertEquals(1, response.getLoanAvailable().size());
        }

        @Test
        public void testViewAvailLoanRequest_NoLoanData() {
            // Arrange
            ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
            when(interfaceServices.allAvailableLoan()).thenThrow(NoLoanData.class);

            // Act and Assert
            assertThrows(NoLoanData.class, () -> loanPhase.viewAvailLoanRequest(request));
        }

        @Test
        public void testViewAvailLoanRequest_LoanServiceException() {
            // Arrange
            ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
            when(interfaceServices.allAvailableLoan()).thenThrow(LoanServiceException.class);

            // Act and Assert
            assertThrows(LoanServiceException.class, () -> loanPhase.viewAvailLoanRequest(request));
        }
    }

