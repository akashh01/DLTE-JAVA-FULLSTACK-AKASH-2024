package loans.web.service.loanwebservices;
import com.fasterxml.jackson.databind.ObjectMapper;
import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.services.CustomerAuthServices;
import loans.web.service.loanwebservices.security.controller.CustomerSignUp;
import loans.web.service.loanwebservices.security.handler.CustomerFailureHandler;
import loans.web.service.loanwebservices.security.handler.CustomerSuccessHandler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class SecurityTest {

    @Mock
    HttpSession session;
    @Mock
    private CustomerAuthServices customerAuthInterface;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private Authentication authentication;
    @InjectMocks
    private CustomerSuccessHandler customerSuccessHandler;
    @Mock
    private AuthenticationException exception;
    @InjectMocks
    private CustomerFailureHandler customerFailureHandler;
    @Mock
    private PasswordEncoder passwordEncoder;
    private MockMvc mockMvc;
    @InjectMocks
    private CustomerSignUp controller;

    @Test
    public void testOnAuthenticationSuccess_ActiveCustomer() throws Exception {
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerStatus("active");
        customer.setAttempts(2);
        when(authentication.getPrincipal()).thenReturn(customer);

        // Act
        customerSuccessHandler.onAuthenticationSuccess(request, response, authentication);

        // Assert
        verify(customerAuthInterface).updateAttempts(customer);
    }

    @Test
    public void testOnAuthenticationSuccess_InactiveCustomer() throws Exception {
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerStatus("Inactive");

        when(authentication.getPrincipal()).thenReturn(customer);

        // Act
        customerSuccessHandler.onAuthenticationSuccess(request, response, authentication);

        // Assert
        Mockito.verify(response).encodeRedirectURL("null/mybank/loanlogin?errors=This account is suspended, please contact admin to activate the account");
    }

//fail

//    @Test
   // @WithMockUser(username = "shake123", password = "shake123")
//
//    public void testOnAuthenticationFailure_ActiveCustomer_LessThanThreeAttempts() throws Exception {
//        // Arrange
//        Customer customer1 = new Customer();
//        customer1.setCustomerId(100001);
//        customer1.setCustomerName("shreyas");
//        customer1.setCustomerAddress("udupi");
//        customer1.setCustomerStatus("active");
//        customer1.setCustomerContact(7418529630L);
//        customer1.setUsername("shreyas12");
//        customer1.setPassword("pass1");
//        customer1.setAttempts(2);
//
//        when(request.getSession(false)).thenReturn(session);
//        when(request.getParameter("username")).thenReturn("shreyas12");
//        when(customerAuthInterface.findByUserName("shreyas12")).thenReturn(customer1);
//
//        // Act
//        customerFailureHandler.onAuthenticationFailure(request, response, exception);
//
//        // Assert
//        verify(customerAuthInterface).updateAttempts(customer1);
//    }


    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testSaveProfile() {
        // Mock customer data
        Customer customer = new Customer();
        customer.setUsername("testUser");
        customer.setPassword("testPassword");

        // Mock repository response
        Mockito.when(customerAuthInterface.signingUp(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        // Mock password encoder response
        Mockito.when(passwordEncoder.encode(ArgumentMatchers.anyString())).thenReturn("encodedPassword");

        // Perform save operation
        Customer savedCustomer = controller.save(customer);

        // Verify that repository method is called with the correct argument
        Mockito.verify(customerAuthInterface).signingUp(customer);

        // Verify that password encoder is called with the correct argument
        Mockito.verify(passwordEncoder).encode("testPassword");

        // Verify the returned customer object
        assertEquals(customer.getUsername(), savedCustomer.getUsername());
        assertEquals("encodedPassword", savedCustomer.getPassword()); // Assuming password was encoded correctly
    }


    // Helper method to convert object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}