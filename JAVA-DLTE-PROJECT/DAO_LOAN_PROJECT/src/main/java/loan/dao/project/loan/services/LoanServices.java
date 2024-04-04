package loan.dao.project.loan.services;


import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


//"LoanException" when there is no loan scheme available
@Service
public class LoanServices implements LoanInterface {
     @Autowired
     JdbcTemplate jdbcTemplate;
     Logger logger= LoggerFactory.getLogger(LoanServices.class);


     public class LoanAvailableMapper implements RowMapper<LoanAvailable>{
          @Override
          public LoanAvailable mapRow(ResultSet rs, int rowNum) throws SQLException {
               LoanAvailable loanAvailable=new LoanAvailable();
               loanAvailable.setLoanNumber(rs.getInt(1));
               loanAvailable.setLoanType(rs.getString(2));
               loanAvailable.setLoanName(rs.getString(3));
               loanAvailable.setLoanDescription(rs.getString(4));
               loanAvailable.setLoanRoi(rs.getDouble(5));
               return loanAvailable;
          }
     }



     @Override
     public List<LoanAvailable> allAvailableLoan() {
          List<LoanAvailable> allAvailLoan;
          allAvailLoan = jdbcTemplate.query("select * from MYBANK_APP_LOANAVAILABLE", new LoanAvailableMapper());
//          try {
//               allAvailLoan = jdbcTemplate.query("select * from MYBANK_APP_LOANAVAILABLE", new LoanAvailableMapper());
//               if (allAvailLoan == null) {
//                   // logger.info(NoLoanData.toS);
//                    throw new NoLoanData();
//               } else {
//                    return allAvailLoan;
//               }

//
//          }catch (InputMismatchException e){
//               System.out.println(e);
//          }
          return allAvailLoan;
     }



     @Override
     public List<LoanAvailable> findByLoanType(String loanType) {
          return null;
     }
}
