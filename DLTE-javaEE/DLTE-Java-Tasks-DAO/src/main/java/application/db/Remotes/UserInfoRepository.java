package application.db.Remotes;

import application.db.Entities.Customer;

import java.util.Date;
import java.util.List;


public interface UserInfoRepository {
    boolean validateUser(String username);
    void DepositAmountInto(String username,Long amount);
    void addInformation(Customer customer);
    boolean passwordValidate(String username, String password);
    public List findAll();
    public List findByUsername(String username);
    public List findByDateAndUsername(String username,String date);


}
