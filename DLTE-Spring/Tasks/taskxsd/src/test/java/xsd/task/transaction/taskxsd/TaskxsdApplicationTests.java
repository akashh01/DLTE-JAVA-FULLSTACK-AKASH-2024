//package xsd.task.transaction.taskxsd;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class TaskxsdApplicationTests {
//       @Mock
//      private JdbcTemplate jdbcTemplate;
//       @InjectMocks
//    private TransactionService transactionService;
//
//       private List<Transactions> initalTransactions(){
//           List<Transactions> newList=new ArrayList<>();
//           Transactions transactionsOne=new Transactions(14555L,"12/02/2024","Akash","Ajay",5000L,"Friend");
//           Transactions transactionsTwo=new Transactions(63635L,"13/02/2024","Amal","Ajay",6000L,"Friend");
//           newList.add(transactionsOne);
//           newList.add(transactionsTwo);
//           return newList;
//       }
//
//    @Test
//    void testGetByAmount(){
//        Transactions transactionsOne=new Transactions(1555484L,"12/2/2029","Akash","Ajay",5000L,"Emergency");
//        Transactions transactionsTwo=new Transactions(98746L,"13/3/2026","Amal","Bhaskar",6000L,"Emergency");
//
//        List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo).collect(Collectors.toList());
//        when(jdbcTemplate.query(anyString(),any(Object[].class),any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);
//
//        List<Transactions> actualOne=transactionService.apiByAmount(5000L);
//        System.out.println(actualOne);
//        assertEquals(transactionsList,actualOne);
//
//
//
//    }
//    //fail
//    @Test
//    void testUpdateRemarks(){
//           List<Transactions> test=initalTransactions();
//        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(TransactionService.TransactionMapper.class))).thenReturn(test);
//        Transactions result=transactionService.updateTransaction(test.get(0));
//        assertEquals(test.get(1).toString(),result.toString());
//
//    }
//
//
//    @Test
//    void testBySender(){
//        Transactions transactionsOne=new Transactions(1555484L,"12/2/2029","Akash","Ajay",5000L,"Emergency");
//        Transactions transactionsTwo=new Transactions(98746L,"13/3/2026","Amal","Bhaskar",6000L,"Emergency");
//        Transactions transactionsThree=new Transactions(982365L,"14/3/2026","Amaya","Akshay",78000L,"Emergency");
//
//        List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo,transactionsThree).collect(Collectors.toList());
//        when(jdbcTemplate.query(anyString(),any(Object[].class),any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);
//
//        List<Transactions> result=transactionService.apiBySender("Ramesh");
//        assertNotNull(result);
//        assertEquals(transactionsList,result);
//    }
//    @Test
//    void testRemoveTransactionBetweenDates() {
//        String startDate ="01/01/2024";
//        String endDate ="01/31/2024";
//        when(jdbcTemplate.update(any(String.class), any(), any())).thenReturn(1);
//        String result = transactionService.removeTransaction(startDate, endDate);
//
//        assertEquals("removed", result);
//        assertNotEquals("removed",result);
//    }
//    @Test
//    void testByReciever(){
//        Transactions transactionsOne=new Transactions(1555484L,"12/2/2029","Akash","Ajay",5000L,"Emergency");
//        Transactions transactionsTwo=new Transactions(98746L,"13/3/2026","Amal","Bhaskar",6000L,"Emergency");
//        Transactions transactionsThree=new Transactions(982365L,"14/3/2026","Amaya","Akshay",78000L,"Emergency");
//
//        List<Transactions> transactionsList= Stream.of(transactionsOne,transactionsTwo,transactionsThree).collect(Collectors.toList());
//        when(jdbcTemplate.query(anyString(),any(Object[].class),any(TransactionService.TransactionMapper.class))).thenReturn(transactionsList);
//
//        List<Transactions> result=transactionService.apiByRecever("Ajay");
//        assertNotNull(result);
//        assertEquals(2,result.size());
//
//    }
//
//    @Test
//    void testNewTransaction(){
//        Transactions transactionsOne=new Transactions(1555484L,"12/2/2029","Akash","Ajay",5000L,"Emergency");
//        Transactions transactionsTwo=new Transactions(98746L,"13/3/2026","Amal","Bhaskar",6000L,"Emergency");
//        Transactions transactionsThree=new Transactions(982365L,"14/3/2026","Amaya","Akshay",78000L,"Emergency");
//        //  when(jdbcTemplate.update(anyLong(), any(Date.class), anyString(), anyString(), anyLong(), anyString())).thenReturn(0);
//        Transactions result = transactionService.apiInsert(transactionsOne);
//
//        assertEquals(transactionsOne,result);
//    }
//
//
//
//
//
//
//
//
//}
