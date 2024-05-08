package loans.web.service.loanwebservices;


import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.exceptions.LoanAlreadyExist;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.CustomerInterface;
import loan.dao.project.loan.interfaces.LoanInterface;
import loans.web.service.loanwebservices.mvc.WebController;
import loans.web.service.loanwebservices.restconfigs.RestControllers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class RestEndpoint {
    @MockBean
    private LoanInterface interfaceServices;

    @InjectMocks
    RestControllers restControllers;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("loandao");

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerInterface customerInterface;


    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testDepositAvailedSuccess() throws Exception {
            String request = "{\n" +
                    "\"customerNumber\": 121,\n" +
                    "\"loanAmount\": 50000,\n" +
                    "\"loanAvailNumber\": 100,\n" +
                    "\"loanEmi\": 8.2,\n" +
                    "\"loanNumber\": 101,\n" +
                    "\"loanTenure\": 18\n" +
                    "}";
            mockMvc.perform(post("/mybank/loan/apply").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isOk());
    }

    //customer number invalid
    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testDepositAvailedCustomerNum() throws Exception {
        String request = "{\n" +
                "\"customerNumber\": 1454,\n" +  //CUSTOMER NUMBER ONLY 3 DIGIT
                "\"loanAmount\": 50000,\n" +
                "\"loanAvailNumber\": 100,\n" +
                "\"loanEmi\": 8.2,\n" +
                "\"loanNumber\": 101,\n" +
                "\"loanTenure\": 18\n" +
                "}";
        mockMvc.perform(post("/mybank/loan/apply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(resourceBundle.getString("EXV003"))));
    }


    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testLoanAmount() throws Exception {
        String request = "{\n" +
                "\"customerNumber\": 101,\n" +
                "\"loanAmount\": -500,\n" +  //AMOUNT SHOULD BE POSITIVE
                "\"loanAvailNumber\": 100,\n" +
                "\"loanEmi\": 8.2,\n" +
                "\"loanNumber\": 101,\n" +
                "\"loanTenure\": 18\n" +
                "}";
        mockMvc.perform(post("/mybank/loan/apply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(resourceBundle.getString("EXV002"))));
    }


    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testLoanAvailNum() throws Exception {
        String request = "{\n" +
                "\"customerNumber\": 101,\n" +
                "\"loanAmount\": 500,\n" +  //AMOUNT SHOULD BE POSITIVE
                "\"loanEmi\": null,\n" +
                "\"loanNumber\": 101,\n" +
                "\"loanTenure\": 18\n" +
                "}";
        mockMvc.perform(post("/mybank/loan/apply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(resourceBundle.getString("EXV001"))));
    }

    @Test
    @WithMockUser(username = "akash", password = "shake123")
    public void testAvailLoanApi_LoanAddedSuccessfully() throws Exception {
        // Mocking necessary objects
        LoanAvailed loanAvailed = new LoanAvailed();
        loanAvailed.setLoanAmount(12100L);
        loanAvailed.setLoanEmi(8.2);
        loanAvailed.setLoanNumber(121L);
        loanAvailed.setLoanTenure(8);
        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn("akash"); // Ensure correct username is returned
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        // Mocking customer
        Customer customer1 = new Customer();
        customer1.setCustomerName("akash");
        customer1.setCustomerAddress("kannur");
        customer1.setCustomerContact(99999999999L);
        customer1.setUsername("akash");
        customer1.setPassword("akas12");
        customer1.setCustomerId(126);
        customer1.setCustomerStatus("Active");
        customer1.setAttempts(0);

        when(customerInterface.findByUserName("akash")).thenReturn(customer1);

        when(interfaceServices.createNewLoan(any())).thenReturn("New loan has been applied successully");

        ResponseEntity<Object> responseEntity = restControllers.availLoanApi(loanAvailed);

        // Assert the response
        assertEquals(HttpServletResponse.SC_OK, responseEntity.getStatusCodeValue());
        assertEquals("New loan has been applied successully", responseEntity.getBody());
    }


}
