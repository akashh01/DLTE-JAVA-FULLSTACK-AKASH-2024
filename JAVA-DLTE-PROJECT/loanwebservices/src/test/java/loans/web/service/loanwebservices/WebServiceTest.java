package loans.web.service.loanwebservices;

import loans.web.service.loanwebservices.configs.LoanPhase;
import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class WebServiceTest {
    private static LoanAvailable loanAvailable1=new LoanAvailable();
    private static LoanAvailable loanAvailable2=new LoanAvailable();
    private static LoanAvailable loanAvailable3=new LoanAvailable();
    private static List<LoanAvailable> loanAvailableList= Stream.of(loanAvailable1,loanAvailable2,loanAvailable3).collect(Collectors.toList());
    @InjectMocks
    private LoanPhase loanPhase;

    @MockBean
    private LoanInterface interfaceServices;

    @Mock
    private SpringApplicationBuilder springApplicationBuilder;

    @BeforeEach
    public void setup(){
        loanAvailable1.setLoanNumber(121);
        loanAvailable1.setLoanName("Apna loan");
        loanAvailable1.setLoanRoi(8.2);
        loanAvailable1.setLoanDescription("good loan");
        loanAvailable1.setLoanType("Persoanal");

        loanAvailable2.setLoanNumber(122);
        loanAvailable2.setLoanName("Sabka loan");
        loanAvailable2.setLoanRoi(8.2);
        loanAvailable2.setLoanDescription("good loan");
        loanAvailable2.setLoanType("Gold");

        loanAvailable2.setLoanNumber(123);
        loanAvailable2.setLoanName("Stay healthy");
        loanAvailable2.setLoanRoi(8.2);
        loanAvailable2.setLoanDescription("good loan");
        loanAvailable2.setLoanType("Health");
        loanAvailableList=Stream.of(loanAvailable1,loanAvailable2,loanAvailable3).collect(Collectors.toList());
    }

    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testViewAllAvailableLoan_Success() throws LoanServiceException, NoLoanData {
        // Mocking necessary objects
        when(interfaceServices.allAvailableLoan()).thenReturn(loanAvailableList);
        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);
        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
        assertEquals(loanAvailableList.size(), response.getLoanAvailable().size());
        assertEquals(loanAvailableList.get(1).getLoanNumber(), response.getLoanAvailable().get(1).getLoanNumber());
    }

    @Test
    public void testConfigure() {
        // Initialize mocks
        openMocks(this);

        // Create an instance of ServletInitializer
        ServletInitializer servletInitializer = new ServletInitializer();

        // Mock the sources() method call
        Class<LoanwebservicesApplication> applicationClass = LoanwebservicesApplication.class;
        when(springApplicationBuilder.sources(applicationClass)).thenReturn(springApplicationBuilder);

        // Call the configure method
        SpringApplicationBuilder returnedBuilder = servletInitializer.configure(springApplicationBuilder);

        // Verify that sources() method was called with correct argument
        verify(springApplicationBuilder).sources(applicationClass);

        // Verify that the returned builder is the same as the mock
        assert returnedBuilder == springApplicationBuilder;
    }

    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testViewAllAvailableLoan_ServiceException() throws LoanServiceException, NoLoanData {
        // Stubbing service to throw LoanServiceException
        when(interfaceServices.allAvailableLoan()).thenThrow(new LoanServiceException("Loan service exception"));

        // Call the method to test
        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);

        // Assert the response

        assertNotNull(response.getServiceStatus().getMessage());
    }

    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testViewAllAvailableLoan_NoLoanData() throws LoanServiceException, NoLoanData {
        // Stubbing service to throw NoLoanData exception
        when(interfaceServices.allAvailableLoan()).thenThrow(new NoLoanData("No loan data"));

        // Call the method to test
        ViewAllAvailableLoanRequest request = new ViewAllAvailableLoanRequest();
        ViewAllAvailableLoanResponse response = loanPhase.viewAvailLoanRequest(request);

        // Assert the response
        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
        assertNotNull(response.getServiceStatus().getMessage());
    }

}
