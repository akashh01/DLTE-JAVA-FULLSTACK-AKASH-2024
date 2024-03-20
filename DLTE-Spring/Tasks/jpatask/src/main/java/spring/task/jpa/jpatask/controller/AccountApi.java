package spring.task.jpa.jpatask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.task.jpa.jpatask.models.Account;
import spring.task.jpa.jpatask.services.AccountServices;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountApi {
    @Autowired
    AccountServices accountServices;
    //posting done with {
    //    "username": "alan",
    //    "password": 10000,
    //    "address": "bangalore",
    //    "email":"akash@gmail.com",
    //    "contact": 5545455,
    //    "initialBalance":5000
    //}
    @PostMapping("/")
    public Account apiSave(@RequestBody Account account){
        return accountServices.callSave(account);
    }
    
    @PutMapping(value="/update",consumes = "application/json")
    public Account apiUpdate(@RequestBody Account account){
       return accountServices.callSave(account);
    }

    @GetMapping("/")
    public List<Account> apiCallAll(){
        return accountServices.callAll();
    }




}
