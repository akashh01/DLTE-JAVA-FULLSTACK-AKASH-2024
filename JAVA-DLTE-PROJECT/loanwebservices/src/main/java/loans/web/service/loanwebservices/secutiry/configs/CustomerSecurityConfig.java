package loans.web.service.loanwebservices.secutiry.configs;

import loan.dao.project.loan.services.CustomerAuthServices;
import loans.web.service.loanwebservices.secutiry.handler.CustomerFailureHandler;
import loans.web.service.loanwebservices.secutiry.handler.CustomerSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("loan.dao.project.loan")
public class CustomerSecurityConfig {
    @Autowired
    CustomerAuthServices services;
    AuthenticationManager manager;
    @Autowired
    CustomerSuccessHandler successHandlers;
    @Autowired
    CustomerFailureHandler failureHandler;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.formLogin()
                .usernameParameter("username")
                .failureHandler(failureHandler)
                .successHandler(successHandlers);

        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests().antMatchers("/profile/register").permitAll();
        httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated();


        // 3rd layer
        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(services);
        manager=builder.build();
        httpSecurity.authenticationManager(manager);

        return httpSecurity.build();
    }


}
