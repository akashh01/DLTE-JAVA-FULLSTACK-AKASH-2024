package jpa.hql.sql.springtasktwo.remotes;

import jpa.hql.sql.springtasktwo.model.TransactionOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionJpaRepo extends JpaRepository<TransactionOfAccount,Long> {

//hql quaery
    @Query("from TransactionOfAccount where amount between :amount1 and :amount2")
    List<TransactionOfAccount> lookForRange(Long amount1,Long amount2);
//sql native query
    @Query(value ="select * from transaction_of_account where username=:user and transaction_type=:type",nativeQuery = true)
    List<TransactionOfAccount> lookUpByTypeUser(String user,String type);

}
