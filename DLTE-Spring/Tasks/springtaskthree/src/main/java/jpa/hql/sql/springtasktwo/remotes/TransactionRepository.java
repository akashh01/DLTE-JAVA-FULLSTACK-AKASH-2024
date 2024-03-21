package jpa.hql.sql.springtasktwo.remotes;

import jpa.hql.sql.springtasktwo.model.TransactionOfAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionOfAccount,Long> {
}
