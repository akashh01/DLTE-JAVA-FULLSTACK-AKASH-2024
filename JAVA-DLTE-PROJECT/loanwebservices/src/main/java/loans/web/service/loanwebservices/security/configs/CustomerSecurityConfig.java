package loans.web.service.loanwebservices.security.configs;


import loan.dao.project.loan.services.CustomerAuthServices;
import loans.web.service.loanwebservices.security.handler.CustomerFailureHandler;
import loans.web.service.loanwebservices.security.handler.CustomerSuccessHandler;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.ResourceBundle;

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

    ResourceBundle resourceBundle=ResourceBundle.getBundle("webservice");

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration(); //config object holds cors details
        configuration.setAllowedOriginPatterns(Arrays.asList(resourceBundle.getString("html.link"))); //req from this org will be allowed
        configuration.addAllowedMethod("*"); //get post put delete
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();  //basic authentication filter
        httpSecurity.formLogin().loginPage(resourceBundle.getString("login.endpoint")).
                usernameParameter("username").
                failureHandler(failureHandler).
                successHandler(successHandlers);
        httpSecurity.csrf().disable();  //cross site request forgery
        httpSecurity.cors();
        httpSecurity.authorizeRequests().antMatchers(resourceBundle.getString("permit.image")).permitAll();
        httpSecurity.authorizeRequests().antMatchers(resourceBundle.getString("permit.style")).permitAll();
        httpSecurity.authorizeRequests().antMatchers(resourceBundle.getString("permit.script")).permitAll();
        httpSecurity.logout().permitAll();
        httpSecurity.authorizeRequests().antMatchers(resourceBundle.getString("permit.login")).permitAll();
        httpSecurity.authorizeRequests().antMatchers(resourceBundle.getString("permit.wsdl")).permitAll();
        httpSecurity.authorizeRequests().antMatchers(resourceBundle.getString("permit.register")).permitAll();
        httpSecurity.authorizeRequests().antMatchers(resourceBundle.getString("permit.api")).permitAll();
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(services);
        manager=builder.build();
        httpSecurity.authenticationManager(manager);
        return httpSecurity.build();
    }


}
