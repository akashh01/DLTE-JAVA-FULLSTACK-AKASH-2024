package security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    UserServices service;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        MyBankUsers myBankUsers= (MyBankUsers) authentication.getPrincipal();
        if(myBankUsers.getStatus()!=0){
            if(myBankUsers.getStatus()>1){
                myBankUsers.setAttempts(1);
                service.updateAttempts(myBankUsers);
            }
            super.setDefaultTargetUrl("/web/dashboard");
        }
        else{
            logger.warn("Max attempts reached contact admin");
            super.setDefaultTargetUrl("/web/?error=contact admin");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
