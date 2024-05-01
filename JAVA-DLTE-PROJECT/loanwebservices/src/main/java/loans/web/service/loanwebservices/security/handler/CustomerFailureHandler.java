package loans.web.service.loanwebservices.security.handler;

import loan.dao.project.loan.entities.Customer;

import loan.dao.project.loan.services.CustomerAuthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
@ComponentScan("loan.dao.project.loan")
public class CustomerFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    CustomerAuthServices service;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");
    Logger logger = LoggerFactory.getLogger(CustomerFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username= request.getParameter("username");
       try {
           Customer customer = service.findByUserName(username);
           if (customer != null) {
               if (!customer.getCustomerStatus().equals("Inactive")) {
                   if (customer.getAttempts() < customer.getMaxAttempt()) {
                       customer.setAttempts(customer.getAttempts() + 1);
                       service.updateAttempts(customer);
                       logger.warn(resourceBundle.getString("customer.password.invalid"));
                       int leftAttempts=4;
                       exception = new LockedException(leftAttempts-customer.getAttempts() + " " + resourceBundle.getString("customer.password.attempts"));
                       String err = customer.getAttempts() + " " + exception.getMessage();
                       logger.warn(err);

                       setDefaultFailureUrl(resourceBundle.getString("login.error.map") + exception.getMessage());
                   } else {
                       service.updateStatus(customer);
                       logger.warn(resourceBundle.getString("attempt.max"));
                       exception = new LockedException(resourceBundle.getString("attempt.max"));
                       setDefaultFailureUrl(resourceBundle.getString("login.error.map") + exception.getMessage());
                   }
               } else {
                   logger.warn(resourceBundle.getString("account.suspended"));
                   exception = new LockedException(resourceBundle.getString("suspended.account"));
                   super.setDefaultFailureUrl(resourceBundle.getString("login.error.map") + exception.getMessage());
                   //super.setDefaultFailureUrl("/login/?error="+exception.);
               }
           } else {
               logger.warn(resourceBundle.getString("account.suspended"));
               exception = new LockedException("no account");
               super.setDefaultFailureUrl(resourceBundle.getString("login.error.map") + exception.getMessage());
           }
       }catch (UsernameNotFoundException e){
           logger.info(e.toString());
           logger.warn(resourceBundle.getString("account.suspended"));
           exception = new LockedException(resourceBundle.getString("incorrect.username"));
           super.setDefaultFailureUrl(resourceBundle.getString("login.error.map") + exception.getMessage());
       }

        super.onAuthenticationFailure(request, response, exception);

}}
