package jpa.hql.sql.springtasktwo.controller;

import jpa.hql.sql.springtasktwo.model.TransactionOfAccount;
import jpa.hql.sql.springtasktwo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionApi {
    @Autowired
    TransactionService transactionService;
//   <root>
//    <transactionId>10002</transactionId>
//    <username>Akash</username>
//    <accountId>85000</accountId>
//    <amount>5000</amount>
//    <transactionType>deposit</transactionType>
//</root>
//posting data to table
    @PostMapping(value="/",consumes = "application/xml")
    public TransactionOfAccount apiSave(@RequestBody TransactionOfAccount transactionUser){
        return transactionService.callSave(transactionUser);
    }
//fetching data by username and type
    @GetMapping("/details/{username}/{type}")
    public List<TransactionOfAccount> apiByType(@PathVariable("username") String username,@PathVariable("type") String type){
        return transactionService.callByUserType(username,type);
    }
//fethning data by range of transaction amount
    @GetMapping("/range/{amount1}/{amount2}")
    public List<TransactionOfAccount> apiByType(@PathVariable("amount1") Long amount1, @PathVariable("amount2") Long amount2){
        return transactionService.callByRange(amount1,amount2);
    }

}
