package loans.web.service.loanwebservices;

import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.interfaces.LoanInterface;
import loan.dao.project.loan.services.CustomerAuthServices;
import loans.web.service.loanwebservices.mvc.WebController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.SQLSyntaxErrorException;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
public class ControllersTest {
    private MockMvc mockMvc2;
    @InjectMocks
    public WebController webControllers;

    @Mock
    LoanInterface loanInterface;
    @Mock
    CustomerAuthServices customerAuthServices;

    @Mock
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        mockMvc2 = MockMvcBuilders.standaloneSetup(webControllers).build();
    }
    @Test
    public void testDashBoardView() {
       // WebController webController=new WebController();
        String viewName = webControllers.viewing();
        assertEquals("ViewAll", viewName);
    }

    @Test
    void testHomePage() throws Exception {
        mockMvc2.perform(get("/mybank/loanlogin"))
                .andExpect(view().name("index"));
    }

    @Test
    public void testdashboard(){
        String dashboardpage = webControllers.homePage();
        assertEquals("dashboard",dashboardpage);
    }

    @Test
    public void testerror(){
        String errorpage = webControllers.errorPage();
        assertEquals("error",errorpage);
    }

    @Test
    void testLoginError() {
      String landingpage = webControllers.landing();
      assertEquals("index",landingpage);
    }

    @Test
    public void testSaveLoanView() throws LoanServiceException {
        Model model = mock(Model.class);
        List<LoanAvailable> availableLoans = new ArrayList<>();
        LoanAvailable loan1 = new LoanAvailable();
        loan1.setLoanName("Personal Loan");
        loan1.setLoanNumber(1);
        availableLoans.add(loan1);
        when(loanInterface.allAvailableLoan()).thenReturn(availableLoans);
        String result = webControllers.save("Personal Loan", model);
        verify(model).addAttribute(eq("newAdditionalLoan"), any(LoanAvailable.class));
        assertEquals("newloan", result);
    }

    @Test
    void testCustomerName() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(123);
        customer.setCustomerName("Akash");
        customer.setCustomerAddress("banglore");
        customer.setCustomerStatus("active");
        customer.setCustomerContact(8277263396L);
        customer.setUsername("user");
        customer.setPassword("1234");
        customer.setAttempts(1);

        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("username");

        when(customerAuthServices.findByUserName("username")).thenReturn(customer);

        mockMvc2.perform(get("/mybank/name"))
                .andExpect(status().isOk())
                .andExpect(content().string("Akash"));
    }

    @Test
    public void testPasswordMatch() {
        CustomerAuthServices customerAuthServices = mock(CustomerAuthServices.class);
        passwordEncoder = new BCryptPasswordEncoder();
        String username = "Akash";
        String rawPassword = "akash123";

        String encodedPassword =passwordEncoder.encode(rawPassword);

        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(encodedPassword);
        when(customerAuthServices.loadUserByUsername(username))
                .thenReturn(customer);

        UserDetails userDetails = customerAuthServices.loadUserByUsername(username);

        String enteredPassword="akash123";

        assertTrue(passwordEncoder.matches(enteredPassword, userDetails.getPassword()));
    }

}




