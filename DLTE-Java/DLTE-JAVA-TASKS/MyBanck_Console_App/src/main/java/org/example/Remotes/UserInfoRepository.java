package org.example.Remotes;

import org.example.Entities.UserInformation;

public interface UserInfoRepository {
    UserInformation validateUser(String username);
    void DepositAmountInto(String username,Long amount);
    void addInformation(UserInformation userInformation);
}
