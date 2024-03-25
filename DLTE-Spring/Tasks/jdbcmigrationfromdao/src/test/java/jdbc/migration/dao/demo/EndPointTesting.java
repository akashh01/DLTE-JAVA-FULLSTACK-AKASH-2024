package jdbc.migration.dao.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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

import java.rmi.UnexpectedException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import java.util.Date;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EndPointTesting {
    @MockBean
    private TransactionService transactionService;
    @InjectMocks
    private TransactionController transactionController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSenderFilter() throws Exception {
        Transactions transactionsOne=new Transactions(1555484L,Date.valueOf("2024-03-02"),"Akash","Ajay",5000L,"Emergency");
        Transactions transactionsTwo=new Transactions(98746L,Date.valueOf("2024-03-03"),"Amal","Bhaskar",6000L,"Emergency");
        Transactions transactionsThree=new Transactions(982365L,Date.valueOf("2024-03-03"),"Amaya","Akshay",78000L,"Emergency");
        List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo,transactionsTwo,transactionsThree).collect(Collectors.toList());
        List<Transactions> expectedList= Stream.of(transactionsOne).collect(Collectors.toList());
       when(transactionService.apiBySender("Ajay")).thenReturn(expectedList);
        mockMvc.perform(get("/jdbctransaction/sender/Ajay")).andExpect(status().isOk()).
                andExpect(jsonPath("$[0].transactionId").value(transactionsOne.getTransactionId())).
                andExpect(jsonPath("$[0].transactionDate",is(equalTo(transactionsOne.getTransactionDate().toString())))).
                andExpect(jsonPath("$[0].transactionBy").value(transactionsOne.getTransactionBy())).
                andExpect(jsonPath("$[0].transactionTo").value(transactionsOne.getTransactionTo())).
                andExpect(jsonPath("$[0].transactionAmount").value(transactionsOne.getTransactionAmount())).
                andExpect(jsonPath("$[0].transactionFor").value(transactionsOne.getTransactionFor()));

    }

    @Test
    void testRecieverFilter() throws Exception {
        Transactions transactionsOne=new Transactions(1555484L,Date.valueOf("2024-03-02"),"Akash","Ajay",5000L,"Emergency");
        Transactions transactionsTwo=new Transactions(98746L,Date.valueOf("2024-03-03"),"Amal","Bhaskar",6000L,"Emergency");
        Transactions transactionsThree=new Transactions(982365L,Date.valueOf("2024-03-03"),"Amaya","Akshay",78000L,"Emergency");
        List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo,transactionsTwo,transactionsThree).collect(Collectors.toList());
        List<Transactions> expectedList= Stream.of(transactionsThree).collect(Collectors.toList());
        when(transactionService.apiByRecever("Ajay")).thenReturn(expectedList);
        mockMvc.perform(get("/jdbctransaction/recieve/Ajay")).andExpect(status().isOk()).
                andExpect(jsonPath("$[0].transactionId").value(transactionsOne.getTransactionId())).
                andExpect(jsonPath("$[0].transactionDate",is(equalTo(transactionsOne.getTransactionDate().toString())))).
                andExpect(jsonPath("$[0].transactionBy").value(transactionsOne.getTransactionBy())).
                andExpect(jsonPath("$[0].transactionTo").value(transactionsOne.getTransactionTo())).
                andExpect(jsonPath("$[0].transactionAmount").value(transactionsOne.getTransactionAmount())).
                andExpect(jsonPath("$[0].transactionFor").value(transactionsOne.getTransactionFor()));
        when(transactionService.apiByRecever("ABAY")).thenReturn(transactionsList);
        mockMvc.perform(get("/jdbctransaction/recieve/ABAY")).andExpect(status().isBadRequest());



    }



    @Test
    void testAmount() throws Exception{
        Transactions transactionsOne=new Transactions(1555484L,Date.valueOf("2024-03-02"),"Akash","Ajay",6000L,"Emergency");
        Transactions transactionsTwo=new Transactions(98746L,Date.valueOf("2024-03-03"),"Amal","Bhaskar",6000L,"Emergency");
        Transactions transactionsThree=new Transactions(982365L,Date.valueOf("2024-03-03"),"Amaya","Akshay",78000L,"Emergency");
       // List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo,transactionsTwo,transactionsThree).collect(Collectors.toList());
        List<Transactions> expectedList= Stream.of(transactionsOne).collect(Collectors.toList());
        when(transactionService.apiBySender("Ajay")).thenReturn(expectedList);
        mockMvc.perform(get("/jdbctransaction/amount/6000")).andExpect(status().isOk()).
                andExpect(jsonPath("$[0].transactionId").value(transactionsOne.getTransactionId())).
                andExpect(jsonPath("$[0].transactionDate",is(equalTo(transactionsOne.getTransactionDate().toString())))).
                andExpect(jsonPath("$[0].transactionBy").value(transactionsOne.getTransactionBy())).
                andExpect(jsonPath("$[0].transactionTo").value(transactionsOne.getTransactionTo())).
                andExpect(jsonPath("$[0].transactionAmount").value(transactionsOne.getTransactionAmount())).
                andExpect(jsonPath("$[0].transactionFor").value(transactionsOne.getTransactionFor())).
                andExpect(jsonPath("$[1].transactionId").value(transactionsTwo.getTransactionId())).
                andExpect(jsonPath("$[1].transactionDate",is(equalTo(transactionsTwo.getTransactionDate().toString())))).
                andExpect(jsonPath("$[1].transactionBy").value(transactionsTwo.getTransactionBy())).
                andExpect(jsonPath("$[1].transactionTo").value(transactionsTwo.getTransactionTo())).
                andExpect(jsonPath("$[1].transactionAmount").value(transactionsTwo.getTransactionAmount())).
                andExpect(jsonPath("$[1].transactionFor").value(transactionsTwo.getTransactionFor()));

    }


    @Test
    void testNewData() throws Exception{
        Transactions transactionsOne=new Transactions(1555484L, Date.valueOf("2024-03-01"),"Akash","Ajay",5000L,"Emergency");

        String request="{\n"+
                "  \"transactionId\":987412,\n"+
                " \"transactionDate\":\"2024-03-01\",\n"+
                " \"transactionBy\":\"Abhijeet\",\n"+
                " \"transactionTo\":\"Sannath\",\n"+
                " \"transactionAmount\":8000,\n"+
                " \"transactionFor\":\"Freind\"\n "+
                "}";
        mockMvc.perform(post("/jdbctransaction/new").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status().isOk()).
                andExpect(jsonPath("$.transactionId").value(transactionsOne.getTransactionId())).
                andExpect(jsonPath("$.transactionDate",is(equalTo(transactionsOne.getTransactionDate().toString())))).
                andExpect(jsonPath("$.transactionBy").value(transactionsOne.getTransactionBy())).
                andExpect(jsonPath("$.transactionTo").value(transactionsOne.getTransactionTo())).
                andExpect(jsonPath("$.transactionAmount").value(transactionsOne.getTransactionAmount())).
                andExpect(jsonPath("$.transactionFor").value(transactionsOne.getTransactionFor()));

    }
    }


