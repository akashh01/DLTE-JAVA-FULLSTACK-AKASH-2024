package loans.web.service.loanwebservices.secutiry.handler;

import loan.dao.project.loan.entities.Customer;

import loan.dao.project.loan.services.CustomerAuthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        Customer customer=service.findByUserName(username);
        if(customer!=null){
            if (!customer.getCustomerStatus().equals("Inactive")) {
                if (customer.getAttempts()<customer.getMaxAttempt()){
                    customer.setAttempts(customer.getAttempts()+1);
                    service.updateAttempts(customer);
                    logger.warn(resourceBundle.getString("customer.password.invalid"));
                    exception=new LockedException(resourceBundle.getString("customer.password.invalid"));
                }else {
                    service.updateStatus(customer);
                    logger.warn(resourceBundle.getString("attempt.max"));
                    exception=new LockedException(resourceBundle.getString("attempt.max"));
                }
            }else{
                 logger.warn(resourceBundle.getString("account.suspended"));
            }
//        }else{
//            logger.warn(resourceBundle.getString("customer.null"));
//        }
        }
        super.setDefaultFailureUrl("/login?error=true");
        super.onAuthenticationFailure(request, response, exception);

}}
