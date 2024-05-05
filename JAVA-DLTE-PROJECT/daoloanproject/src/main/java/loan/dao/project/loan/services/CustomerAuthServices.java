package loan.dao.project.loan.services;

import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.exceptions.CustomerSignIn;

//import loan.dao.project.loan.interfaces.CustomerInterface;
import loan.dao.project.loan.interfaces.CustomerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Service
public class CustomerAuthServices implements CustomerInterface,UserDetailsService {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("loandao");
    Logger logger = LoggerFactory.getLogger(CustomerAuthServices .class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info(resourceBundle.getString("load.initiated"));
        Customer customers = findByUserName(username);
        if(customers==null) {
            throw new UsernameNotFoundException(username);
        }
        return customers;
    }
    @Override
    public Customer signingUp(Customer customer) {
        try{
            customer.setCustomerStatus("Active");
            String sql="INSERT INTO MYBANK_APP_CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_ADDRESS,CUSTOMER_STATUS,CUSTOMER_CONTACT,USERNAME,PASSWORD) VALUES(CUSTOMER_ID_SEQ.nextval,?,?,?,?,?,?)";
            int rowCount=jdbcTemplate.update(sql,
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerStatus(),
                    customer.getCustomerContact(),
                    customer.getUsername(),
                    customer.getPassword()
                    );
            if(rowCount==1){
                logger.info(resourceBundle.getString("new.customer.signedup"));
                return customer;
            }
            else {
               throw new CustomerSignIn(resourceBundle.getString("customer.sign.in"));
            }
        }catch (DataAccessException exp){
            throw new CustomerSignIn(exp+ resourceBundle.getString("customer.db.sign.in"));

        }
    }
    @Override
    public Customer findByUserName(String username){
        List<Customer> customerList = jdbcTemplate.query("select * from MYBANK_APP_CUSTOMER",new BeanPropertyRowMapper<>(Customer.class));
        Customer customer=filterByUserName(customerList,username);
        logger.info(resourceBundle.getString("find.user"));
        if(customer==null){
            throw new UsernameNotFoundException(username);
        }
        return customer;
    }

    @Override
    public void updateAttempts(Customer customer) {
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set ATTEMPTS=? where USERNAME=?",
                new Object[]{customer.getAttempts(),customer.getUsername()});
        logger.info(resourceBundle.getString("customer.attempt.update"));
    }

    @Override
    public void updateStatus(Customer customer) {
        String status = "Inactive";
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set customer_status=? where username=?",
                status, customer.getUsername());
        logger.info(resourceBundle.getString("customer.status.update"));
    }

    @Override
    public Customer filterByUserName(List<Customer> customerList,String username){
        // Filter the list based on the provided username
        List<Customer> filteredCustomers = customerList.stream()
                .filter(customer -> customer.getUsername().equals(username))
                .collect(Collectors.toList());

        logger.info(resourceBundle.getString("customer.filtered"));
        if(filteredCustomers.size()==0){
            return null;
        }
        else {
            Customer customer=filteredCustomers.get(0);
            logger.info(resourceBundle.getString("no.customer"));
            return customer;
        }
    }


}
