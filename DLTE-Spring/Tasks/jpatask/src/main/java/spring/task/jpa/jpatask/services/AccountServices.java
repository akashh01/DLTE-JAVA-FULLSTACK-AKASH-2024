package spring.task.jpa.jpatask.services;
import java.lang.String;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.task.jpa.jpatask.models.Account;
import spring.task.jpa.jpatask.remotes.AccountRepository;

@Service
public class AccountServices {

     @Autowired
    AccountRepository accountRepository;
    public Account callSave(Account account){
        return accountRepository.save(account);
    }
    public List<Account> callAll(){
        return (List<Account>) accountRepository.findAll();
    }


}
