package spring.task.jpa.jpatask.remotes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.task.jpa.jpatask.models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

}
