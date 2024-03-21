package jpa.hql.sql.springtasktwo.services;

import jpa.hql.sql.springtasktwo.model.TransactionOfAccount;
import jpa.hql.sql.springtasktwo.remotes.TransactionJpaRepo;
import jpa.hql.sql.springtasktwo.remotes.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionJpaRepo transactionJpaRepo;

    public TransactionOfAccount callSave(TransactionOfAccount transaction){
        return transactionRepository.save(transaction);
    }
    public List<TransactionOfAccount> callByUserType(String username,String type){
        return transactionJpaRepo.lookUpByTypeUser(username, type);

    }
    public List<TransactionOfAccount> callByRange(Long amount1,Long amount2){
        return transactionJpaRepo.lookForRange(amount1,amount2);
    }


}
