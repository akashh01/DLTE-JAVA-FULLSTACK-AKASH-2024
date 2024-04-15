package loan.dao.project.loan.services;

import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.exceptions.CustomerSignIn;

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

import java.util.ResourceBundle;

@Service
public class CustomerAuthServices implements UserDetailsService {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    Logger logger = LoggerFactory.getLogger(CustomerAuthServices .class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customers = findByUserName(username);
        if(customers==null)
            throw new UsernameNotFoundException(username);
        return customers;
    }

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

//
//    public Customer findByUserName(String username) {
//        Customer customer;
//        try {
//            customer= jdbcTemplate.queryForObject(
//                    "SELECT * FROM MYBANK_APP_CUSTOMER WHERE USERNAME = ?",
//                    new Object[]{username},
//                    new BeanPropertyRowMapper<>(Customer.class)
//            );
//            if(customer==null){
//                throw new CustomerSignIn(username + resourceBundle.getString("customer.not.exist"));
//
//            }
//            return customer;
//        }catch (EmptyResultDataAccessException exp){
//            throw new CustomerSignIn(username + resourceBundle.getString("customer.not.exist"));
//
//        }
       // logger.info(resourceBundle.getString("customer.not.exist"));

  //  }

    public Customer findByUserName(String username){
        Customer customer = jdbcTemplate.queryForObject("select * from MYBANK_APP_CUSTOMER where username=?",
                new Object[]{username},new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }


    public void updateAttempts(Customer customer) {
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set ATTEMPTS=? where USERNAME=?",
                new Object[]{customer.getAttempts(),customer.getUsername()});
        logger.info(resourceBundle.getString("customer.attempt.update"));
    }


    public void updateStatus(Customer customer) {
        String status = "Inactive";
        jdbcTemplate.update("update MYBANK_APP_CUSTOMER set customer_status=? where username=?",
                status, customer.getUsername());
        logger.info(resourceBundle.getString("customer.status.update"));
    }


}
