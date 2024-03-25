package jdbc.migration.dao.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DemoApplicationTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private TransactionService transactionService;

    @Test
    void testGetByAmount(){
        Transactions transactionsOne=new Transactions(1555484L,new Date("12/2/2029"),"Akash","Ajay",5000L,"Emergency");
        Transactions transactionsTwo=new Transactions(98746L,new Date("13/3/2026"),"Amal","Bhaskar",6000L,"Emergency");

        List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo).collect(Collectors.toList());
        when(jdbcTemplate.query(anyString(),any(Object[].class),any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);

        List<Transactions> actualOne=transactionService.apiByAmount(5000L);
        System.out.println(actualOne);
        assertEquals(transactionsList,actualOne);



    }
     @Test
     void testBySender(){
         Transactions transactionsOne=new Transactions(1555484L,new Date("12/2/2029"),"Akash","Ajay",5000L,"Emergency");
         Transactions transactionsTwo=new Transactions(98746L,new Date("13/3/2026"),"Amal","Bhaskar",6000L,"Emergency");
         Transactions transactionsThree=new Transactions(982365L,new Date("14/3/2026"),"Amaya","Akshay",78000L,"Emergency");

         List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo,transactionsThree).collect(Collectors.toList());
         when(jdbcTemplate.query(anyString(),any(Object[].class),any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);

         List<Transactions> result=transactionService.apiBySender("Ramesh");
         assertNotNull(result);
         assertEquals(transactionsList,result);
     }

     @Test
     void testByReciever(){
         Transactions transactionsOne=new Transactions(1555484L,new Date("12/2/2029"),"Akash","Ajay",5000L,"Emergency");
         Transactions transactionsTwo=new Transactions(98746L,new Date("13/3/2026"),"Amal","Bhaskar",6000L,"Emergency");
         Transactions transactionsThree=new Transactions(982365L,new Date("14/3/2026"),"Amaya","Akshay",78000L,"Emergency");

         List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo,transactionsThree).collect(Collectors.toList());
         when(jdbcTemplate.query(anyString(),any(Object[].class),any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);

         List<Transactions> result=transactionService.apiByRecever("Ajay");
         assertNotNull(result);
         assertEquals(2,result.size());

     }

     @Test
     void testNewTransaction(){
         Transactions transactionsOne=new Transactions(1555484L,new Date("12/2/2029"),"Akash","Ajay",5000L,"Emergency");
         Transactions transactionsTwo=new Transactions(98746L,new Date("13/3/2026"),"Amal","Bhaskar",6000L,"Emergency");
         Transactions transactionsThree=new Transactions(982365L,new Date("14/3/2026"),"Amaya","Akshay",78000L,"Emergency");
       //  when(jdbcTemplate.update(anyLong(), any(Date.class), anyString(), anyString(), anyLong(), anyString())).thenReturn(0);
         Transactions result = transactionService.apiInsert(transactionsOne);

         assertEquals(transactionsOne,result);
     }






}
