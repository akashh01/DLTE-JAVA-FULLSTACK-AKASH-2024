package loan.dao.project.loan.interfaces;


import loan.dao.project.loan.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInterface {
    Customer signingUp(Customer customer);
    Customer findByUserName(String username);
    void updateAttempts(Customer customer);
    void updateStatus(Customer customer);
    Customer filterByUserName(List<Customer> customerList, String username);

}
