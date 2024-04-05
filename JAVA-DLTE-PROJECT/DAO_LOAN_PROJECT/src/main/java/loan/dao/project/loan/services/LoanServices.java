package loan.dao.project.loan.services;


import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ResourceBundle;


//"LoanException" when there is no loan scheme available
@Service
public class LoanServices implements LoanInterface {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    @Autowired
     JdbcTemplate jdbcTemplate;
     Logger logger= LoggerFactory.getLogger(LoanServices.class);

     //implementing row mapper for retriving data
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


     //to fetch all the data from available loan
     @Override
     public List<LoanAvailable> allAvailableLoan() {

             List<LoanAvailable> allAvailLoan = new ArrayList<>();
             try{
                 allAvailLoan = jdbcTemplate.query("select * from MYBANK_APP_LOANAVAILABLE", new LoanAvailableMapper());
                 logger.info(resourceBundle.getString("start.loan.fetch"));
             }
             catch (DataAccessException dae) {
                 logger.error(resourceBundle.getString("db.fetch.error"));
                 //throwing custom exception for any db error that occurs to the customer
                 throw new LoanServiceException(resourceBundle.getString("no.service.exp"));
             }
             if(allAvailLoan.size()==0){
                 //handling the null case using exception
                 logger.warn(resourceBundle.getString("no.loan.data"));
                 throw new NoLoanData(resourceBundle.getString("no.loan.data"));
             }

             logger.info(resourceBundle.getString("loan.success.fetch"));
             return allAvailLoan;
     }



     @Override
     public List<LoanAvailable> findByLoanType(String loanType) {
          return null;
     }
}
