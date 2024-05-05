package loan.dao.project.loan.services;


import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.entities.LoanAvailed;
import loan.dao.project.loan.exceptions.CustomerInactive;
import loan.dao.project.loan.exceptions.LoanAlreadyExist;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;


//"LoanException" when there is no loan scheme available
@Service
public class LoanServices implements LoanInterface {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("loandao");
    @Autowired
    JdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(LoanServices.class);

    //implementing row mapper for retriving data
    public static class LoanAvailableMapper implements RowMapper<LoanAvailable> {
        @Override
        public LoanAvailable mapRow(ResultSet rs, int rowNum) throws SQLException {
            LoanAvailable loanAvailable = new LoanAvailable();
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
        try {
            allAvailLoan = jdbcTemplate.query("select * from MYBANK_APP_LOANAVAILABLE", new LoanAvailableMapper());
            logger.info(resourceBundle.getString("start.loan.fetch"));
        } catch (DataAccessException dae) {
            logger.error(resourceBundle.getString("db.fetch.error"));
            //throwing custom exception for any db error that occurs to the customer
            throw new LoanServiceException(resourceBundle.getString("no.service.exp"));
        }
        if (allAvailLoan.size() == 0) {
            //handling the null case using exception
            logger.warn(resourceBundle.getString("no.loan.data"));
            throw new NoLoanData(resourceBundle.getString("no.loan.data"));
        }

        logger.info(resourceBundle.getString("loan.success.fetch"));
        return allAvailLoan;
    }



    @Override
    public String createNewLoan(LoanAvailed loan) {
        CallableStatementCreator creator = con -> {
            CallableStatement statement = con.prepareCall("{call final_loan_insert(?,?,?,?,?,?)}");  //call procedure
            //statement.setInt(1,loan.getLoanAvailNumber());
            statement.setInt(1, loan.getCustomerNumber());
            statement.setLong(2, loan.getLoanNumber());
            statement.setLong(3, loan.getLoanAmount());
            statement.setDouble(4, loan.getLoanEmi());
            statement.setInt(5, loan.getLoanTenure());
            statement.registerOutParameter(6, Types.VARCHAR);
            return statement;
        };
        //mapping
        Map<String, Object> returnedExecution = jdbcTemplate.call(creator, Arrays.asList(
                new SqlParameter[]{
                        new SqlParameter(Types.NUMERIC),
                        new SqlParameter(Types.NUMERIC),
                        new SqlParameter(Types.NUMERIC),
                        new SqlParameter(Types.NUMERIC),
                        new SqlParameter(Types.NUMERIC),
                        new SqlOutParameter("errOrInfo", Types.VARCHAR),
                }
        ));
        String errorInfo = returnedExecution.get("errOrInfo").toString();
        //based on procedure
        if (errorInfo.equals("SQE001")) {
            throw new LoanAlreadyExist(resourceBundle.getString("loan.exists.customer"));
        } else if (errorInfo.equals("SQE002")) {
            throw new CustomerInactive(resourceBundle.getString("loan.customer.inactive"));
        } else if (errorInfo.equals("SQE003")) {
            throw new NoLoanData(resourceBundle.getString("no.loan.data"));
        } else if (errorInfo.equals("SQE004")) {
            logger.error(resourceBundle.getString("apply.loan.error"));
            throw new LoanServiceException(resourceBundle.getString("no.service.exp"));
        }

        return returnedExecution.get("errOrInfo").toString();


    }

}
