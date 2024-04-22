//package xsd.task.transaction.taskxsd;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import services.transactions.*;
//import xsd.task.transaction.taskxsd.config.SoapPhase;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//public class TestEndPoint {
//    @MockBean
//    private TransactionService transactionService;
//
//    @InjectMocks
//    private SoapPhase soapPhase;
//
//    @Test
//    public void testFilterSender() {
//        List<Transactions> mockTransactions = new ArrayList<>();
//        mockTransactions.add(new Transactions(14555L, "12/02/2024", "Akash", "Ajay", 5000L, "Friend"));
//        when(transactionService.apiBySender("Akash")).thenReturn(mockTransactions);
//        FindBySenderRequest request = new FindBySenderRequest();
//        request.setSenderName("Akash");
//        FindBySenderResponse response = soapPhase.findBySenderRequest(request);
//        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
//        assertEquals("Transactions available", response.getServiceStatus().getMessage());
//    }
//
//    @Test
//    public void testFilterReciever() {
//        List<Transactions> mockTransactions = new ArrayList<>();
//        mockTransactions.add(new Transactions(14555L, "12/02/2024", "Akash", "Ajay", 5000L, "Friend"));
//        when(transactionService.apiByRecever("Ajay")).thenReturn(mockTransactions);
//        FindByRecieverRequest request = new FindByRecieverRequest();
//        request.setRecieverName("Amal"); //fail
//        FindByRecieverResponse response = soapPhase.findByRecieverRequest(request);
//        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
//        assertEquals("Transactions available", response.getServiceStatus().getMessage());
//    }
//
//    @Test
//    public void testFilterAmount() {
//        List<Transactions> mockTransactions = new ArrayList<>();
//        mockTransactions.add(new Transactions(14555L, "12/02/2024", "Akash", "Ajay", 5000L, "Friend"));
//        when(transactionService.apiByAmount(5000L)).thenReturn(mockTransactions);
//        FindByAmountRequest request = new FindByAmountRequest();
//        request.getRecieverName(); //fail
//        FindByAmountResponse response = soapPhase.findByAmountRequest(request);
//        assertNotEquals("SUCCESS", response.getServiceStatus().getStatus());
//        assertNotEquals("Transactions available", response.getServiceStatus().getMessage());
//        assertEquals(1, response.getTransactions().size());
//    }
//
//
//    @Test
//    public void testUpdatingTransaction() {
//        Transactions updateTransaction = new Transactions();
//        updateTransaction.setTransactionId(15000L);
//        updateTransaction.setTransactionDate("8/12/2024");
//        updateTransaction.setTransactionBy("Sender");
//        updateTransaction.setTransactionTo("Receiver");
//        updateTransaction.setTransactionAmount(1000L);
//        updateTransaction.setTransactionFor("new remark");
//        when(transactionService.updateTransaction(any(Transactions.class))).thenReturn(updateTransaction);
//        UpdateRemarksRequest request = new UpdateRemarksRequest();
//        services.transactions.Transactions transaction = new services.transactions.Transactions();
//        transaction.setTransactionId(15000L);
//        transaction.setTransactionDate("8/12/2024");
//        updateTransaction.setTransactionBy("Sender");
//        updateTransaction.setTransactionTo("Receiver");
//        updateTransaction.setTransactionAmount(1000L);
//        updateTransaction.setTransactionFor("old remark");
//        request.setTransactions(transaction);
//        UpdateRemarkResponse response = soapPhase.updatingTransaction(request);
//        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
//        assertEquals("1 \" has been updated\"", response.getServiceStatus().getMessage());
//        assertEquals(1L, response.getTransactions().getTransactionId());
//        assertEquals("Updated remarks", response.getTransactions().getTransactionAmount());
//    }
//
//    @Test
//    public void testRemoveTransactionBetweenDates() {
//        String startDate ="01/01/2024";
//        String endDate ="01/31/2024";
//        when(transactionService.removeTransaction(startDate, endDate)).thenReturn("remove");
//        DeletionRequest request = new DeletionRequest();
//        String start ="01/01/2024";
//        String end ="01/31/2024";
//        request.setStartDate(start);
//        request.setEndDate(end);
//        DeletionResponse response = soapPhase.deletionByCall(request);
//        assertEquals("removed", response.getServiceStatus().getStatus());
//        assertEquals("removed", response.getServiceStatus().getMessage());
//    }
//
//
//
//}
