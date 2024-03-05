package org.example.Remotes;

import org.example.Entities.Customer;

public interface UserInfoRepository {
    Customer validateUser(String username);
    void DepositAmountInto(String username,Long amount);
    void addInformation(Customer customer);
}
