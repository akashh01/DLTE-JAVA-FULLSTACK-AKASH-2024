package loans.web.service.loanwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@PropertySource("classpath:loandao.properties")
public class LoanwebservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanwebservicesApplication.class, args);
    }

}
