package loans.web.service.loanwebservices.security.controller;

import loan.dao.project.loan.entities.Customer;

import loan.dao.project.loan.services.CustomerAuthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

@RestController
@RequestMapping("/profile")
@ComponentScan("loan.dao.project.loan")
public class CustomerSignUp {
    @Autowired
    CustomerAuthServices repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    Logger logger= LoggerFactory.getLogger(CustomerSignUp.class);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");

    @PostMapping("/register")
    public Customer save(@RequestBody Customer customer){
        logger.debug(resourceBundle.getString("Password encoded"));
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return repository.signingUp(customer);
    }
}
