package loans.web.service.loanwebservices;

import loans.web.service.loanwebservices.configs.LoanPhase;
import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import services.loans.ServiceStatus;
import services.loans.ViewAllAvailableLoanRequest;
import services.loans.ViewAllAvailableLoanResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class WebServiceTest {

    @Autowired
   private LoanPhase loanPhase;
//
    @MockBean
    private LoanInterface interfaceServices;

//   @Test
//   @WithMockUser(username = "shake123", password = "shake123")
//    public void testViewAvailLoanRequestSuccess() {
//        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
//        List<LoanAvailable> mockLoanList = new ArrayList<>();
//
//        mockLoanList.add(new LoanAvailable());
//        when(interfaceServices.allAvailableLoan()).thenReturn(mockLoanList);
//        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);
//        assertNotNull(response);
//        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
//        assertNotNull(response.getLoanAvailable());
//        assertEquals(1, response.getLoanAvailable().size());
//    }
    //    @Test
//    public void testViewAvailLoanRequest_null() {
//        // Arrange
//        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
//        List<LoanAvailable> mockLoanList = new ArrayList<>();
//
//        //mockLoanList.add(new LoanAvailable());
//        when(interfaceServices.allAvailableLoan()).thenReturn(mockLoanList);
//
//        // Act
//        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);
//
//        // Assert
//        //assertNotNull(response);
//        assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, response.getServiceStatus().getStatus());
//       // assertNotNull(response.getLoanAvailable());
//       // assertEquals(1, response.getLoanAvailable().size());
//    }
//   @Test
//   @WithMockUser(username = "shake123", password = "shake123")
//    public void testViewAvailLoanRequestNoLoanData() {
//        // Arrange
//        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
//
//        List<LoanAvailable> mockLoanList = new ArrayList<>();
//        //when(interfaceServices.allAvailableLoan()).thenReturn(mockLoanList);
//        when(interfaceServices.allAvailableLoan()).thenThrow(NoLoanData.class);
//
//        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);
//        // Act and Assert
//        //   assertThrows(NoLoanData.class, () -> loanPhase.viewAvailLoanRequest(request));
//        assertEquals(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, response.getServiceStatus().getStatus());
//        //  assertEquals("No loan available,sorry",response.getServiceStatus().getMessage());
//    }
//
//    @Test
//    @WithMockUser(username = "shake123", password = "shake123")
//    public void testViewAvailLoanRequestLoanServiceException() {
//        // Arrange
//        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
//        when(interfaceServices.allAvailableLoan()).thenThrow(LoanServiceException.class);
//        // Act and Assert
//        assertThrows(LoanServiceException.class, () -> loanPhase.viewAvailLoanRequest(request));
//    }
@Test
 @WithMockUser(username = "shake123", password = "shake123")
public void testViewAvailLoanRequest_Success() {
    // Arrange
    ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
    ServiceStatus expectedServiceStatus = new ServiceStatus();
    expectedServiceStatus.setStatus(HttpServletResponse.SC_OK);

    List<LoanAvailable> allLoansDao = Arrays.asList(
            new LoanAvailable(101, "Personal", "Apna loan", "Best loan", 8.3),
            new LoanAvailable(201, "Marriage", "shaadi loan", "Nice loan", 7.5)
    );
    when(interfaceServices.allAvailableLoan()).thenReturn(allLoansDao);
    ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);
    assertNotNull(response);
    assertEquals(expectedServiceStatus.getStatus(), response.getServiceStatus().getStatus());
    assertEquals(2, response.getLoanAvailable().size());
}

    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testViewAvailLoanRequest_ServiceException() {
        // Arrange
        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
        ServiceStatus expectedServiceStatus = new ServiceStatus();
        expectedServiceStatus.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        when(interfaceServices.allAvailableLoan()).thenThrow(LoanServiceException.class);

        // Act
        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);
        assertNotNull(response);
        assertEquals(expectedServiceStatus.getStatus(), response.getServiceStatus().getStatus());
        assertNotNull(response.getServiceStatus().getMessage());
    }

    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testViewAvailLoanRequest_NoLoanData() {
        // Arrange
        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
        ServiceStatus expectedServiceStatus = new ServiceStatus();
        expectedServiceStatus.setStatus(HttpServletResponse.SC_OK);

        when(interfaceServices.allAvailableLoan()).thenThrow(NoLoanData.class);
        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);
        assertNotNull(response);
        assertEquals(expectedServiceStatus.getStatus(), response.getServiceStatus().getStatus());
        assertNotNull(response.getServiceStatus().getMessage());
    }

}
