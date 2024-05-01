package loans.web.service.loanwebservices.security.handler;

import loan.dao.project.loan.entities.Customer;

import loan.dao.project.loan.services.CustomerAuthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;
@Component
@ComponentScan("loan.dao.project.loan")
public class CustomerSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    CustomerAuthServices service;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");
    Logger logger = LoggerFactory.getLogger(CustomerSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        try{
        Customer customer = (Customer) authentication.getPrincipal();
        if (!customer.getCustomerStatus().equals("Inactive")) {
            if (customer.getAttempts() >= 1) {
                customer.setAttempts(1);
                service.updateAttempts(customer);
            }
          //  logger.debug(resourceBundle.getString("security.update"));
            super.setDefaultTargetUrl(resourceBundle.getString("login.success.map"));

        } else {
          //  logger.warn(resourceBundle.getString("security.max"));
            super.setDefaultTargetUrl(resourceBundle.getString("login.error.map")+ resourceBundle.getString("suspended.account"));

        }

    }catch (UsernameNotFoundException e){
            logger.info("no user");
        }
        super.onAuthenticationSuccess(request, response, authentication);
}}
