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
import org.springframework.test.web.servlet.MockMvc;

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
    
    @Test
    public void testDepositAvailed() throws Exception {
        String request = "{\n" +
                "\"customerNumber\": ABC,\n" +
                "\"loanAmount\": 50000,\n" +
                "\"loanAvailNumber\": 100,\n" +
                "\"loanEmi\": 8.2,\n" +
                "\"loanNumber\": 101,\n" +
                "\"loanTenure\": 18\n" +
                "}";
        mockMvc.perform(post("/mybank/loan/apply").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isOk());
    }
}
