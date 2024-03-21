package jdbc.migration.dao.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbctransaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    //for new transaction
    @PostMapping("/new")
    public Transactions saved(@RequestBody Transactions transactions){
        Transactions transactions1=null;
        try{
            transactions1=transactionService.apiInsert(transactions);

        }catch (Exception exp){
            System.out.println(exp);
        }
        return transactions1;

    }
    //for getting all transactions by senders name
    @GetMapping("/sender/{senderName}")
    public List<Transactions> getSender(@PathVariable String senderName){
        List<Transactions> transactionName=null;
        try{
            transactionName=transactionService.apiBySender(senderName);
        }catch (TransactionException exp){
            System.out.println(exp);
        }
        return transactionName;
    }
    //for getting all transaction by recevers name
    @GetMapping("/recieve/{receiverName}")
    public List<Transactions> getReciever(@PathVariable String receiverName){
        List<Transactions> transactionName=null;
        try{
            transactionName=transactionService.apiByRecever(receiverName);
        }catch (TransactionException exp){
            System.out.println(exp);
        }
        return transactionName;
    }
    //for getting all transaction by amount
    @GetMapping("/amount/{amount}")
    public List<Transactions> getAmount(@PathVariable Long amount){
        List<Transactions> transactionName=null;
        try{
            transactionName=transactionService.apiByAmount(amount);
        }catch (TransactionException exp){
            System.out.println(exp);
        }
        return transactionName;
    }



}
