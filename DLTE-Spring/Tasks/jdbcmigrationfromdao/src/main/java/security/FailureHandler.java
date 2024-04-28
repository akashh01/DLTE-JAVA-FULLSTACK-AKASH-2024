package security;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FailureHandler extends SimpleUrlAuthenticationFailureHandler {
    UserServices service;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        MyBankUsers myBankUsers = service.findByUsername(username);
        if(myBankUsers!=null){
            if(myBankUsers.getStatus()!=0){
                if(myBankUsers.getAttempts()< myBankUsers.getMaxAttempt()){
                    myBankUsers.setAttempts(myBankUsers.getAttempts()+1);
                    service.updateAttempts(myBankUsers);
                    logger.warn("Invalid credentials");
                    exception=new LockedException("Attempts are overe");
                    String err = myBankUsers.getAttempts()+" "+exception.getMessage();
                    logger.warn(err);
                    super.setDefaultFailureUrl("/web/?error="+err);
                }
                else{
                    service.updateStatus(myBankUsers);
                    exception=new LockedException("Max Attempts reached max account is suspended");
                    super.setDefaultFailureUrl("/web/?error="+exception.getMessage());
                }
            }
        }
        else{
            super.setDefaultFailureUrl("/web/?error=User not exists");
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
