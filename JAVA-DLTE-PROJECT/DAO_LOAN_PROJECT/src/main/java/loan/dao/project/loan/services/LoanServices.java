package loan.dao.project.loan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


//"LoanException" when there is no loan scheme available
@Service
public class LoanServices {
     @Autowired
     JdbcTemplate jdbcTemplate;

     


}
