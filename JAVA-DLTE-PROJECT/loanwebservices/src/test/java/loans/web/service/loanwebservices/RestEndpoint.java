package loans.web.service.loanwebservices;


import loan.dao.project.loan.interfaces.LoanInterface;
import loans.web.service.loanwebservices.restconfigs.RestControllers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import services.loans.LoanAvailed;

import java.util.ResourceBundle;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class RestEndpoint {
    @MockBean
    private LoanInterface interfaceServices;
    @InjectMocks
    RestControllers restControllers;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");
    @Autowired
    private MockMvc mockMvc;
    //pass
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
    public void testDepositAvailed() throws Exception {
        String request = "{\n" +
                "\"customerNumber\": 1454,\n" +  //CUSTOMER NUMBER ONLY 3 DIGIT
                "\"loanAmount\": 50000,\n" +
                "\"loanAvailNumber\": 100,\n" +
                "\"loanEmi\": 8.2,\n" +
                "\"loanNumber\": 101,\n" +
                "\"loanTenure\": 18\n" +
                "}";
        mockMvc.perform(post("/mybank/loan/apply").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "shake123", password = "shake123")
    public void testLoanAmount() throws Exception {
        String request = "{\n" +
                "\"customerNumber\": 101,\n" +
                "\"loanAmount\": 10011555535343243,\n" +  //AMOUNT SHOULD NOT BE GREATER THAN 10 DIGITS
                "\"loanAvailNumber\": 100,\n" +
                "\"loanEmi\": 8.2,\n" +
                "\"loanNumber\": 101,\n" +
                "\"loanTenure\": 18\n" +
                "}";
        mockMvc.perform(post("/mybank/loan/apply").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isBadRequest());
    }
    @Test
    @WithMockUser(username = "shake123", password = "shake13")
    public void testLoanAmount2() throws Exception {
        String request = "{\n" +
                "\"customerNumber\": 101,\n" +
                "\"loanAmount\": ,\n" +  //AMOUNT SHOULD NOT BE NULL
                "\"loanAvailNumber\": 100,\n" +
                "\"loanEmi\": 8.2,\n" +
                "\"loanNumber\": 101,\n" +
                "\"loanTenure\": 18\n" +
                "}";
        mockMvc.perform(post("/mybank/loan/apply").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isBadRequest());
    }

}
