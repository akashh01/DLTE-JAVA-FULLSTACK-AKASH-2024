package jdbc.migration.dao.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Transactions apiInsert(Transactions transactions){
        int check=jdbcTemplate.update("insert into TRANSACTIONS_TASK values (?,?,?,?,?,?)",
        new Object[]{
                transactions.getTransactionId(),
                transactions.getTransactionDate(),
                transactions.getTransactionBy(),
                transactions.getTransactionAmount(),
                transactions.getTransactionTo(),
                transactions.getTransactionFor()

        });
//        {
//            "transactionId": 1003,
//                "transactionDate":"2024-03-12",
//                "transactionBy": "Amal",
//                "transactionTo":"Hari",
//                "transactionAmount":5000,
//                "transactionFor":"Emergency"
//        }

        if(check!=0)
            return transactions;
        else
            return null;

    }
    //query for all transaction by reciever name
    public List<Transactions> apiByRecever(String receverName){
        return jdbcTemplate.query("select * from TRANSACTIONS_TASK where TRANSACTION_TO=?",
                new Object[]{receverName},
                new TransactionMapper());
    }
    //query for all transaction by amount
    public List<Transactions> apiByAmount(Long amount){
        return jdbcTemplate.query("select * from TRANSACTIONS_TASK where TRANSACTION_AMOUNT=?",
                new Object[]{amount},
                new TransactionMapper());
    }


    //query for all transaction by sender name
    public List<Transactions> apiBySender(String senderName){
        return jdbcTemplate.query("select * from TRANSACTIONS_TASK where TRANSACTION_REMARKS=?",
                new Object[]{senderName},
                new TransactionMapper());
    }



 //for multiple object retrun in sender ,reciver and amount
    public class TransactionMapper implements RowMapper<Transactions>{
        @Override
        public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transactions transactions=new Transactions();
            transactions.setTransactionId(rs.getLong(1));
            transactions.setTransactionDate(rs.getDate(2));
            transactions.setTransactionTo(rs.getString(3));
            transactions.setTransactionAmount(rs.getLong(4));
            transactions.setTransactionFor(rs.getString(5));
            transactions.setTransactionBy(rs.getString(6));
            return transactions;
        }
    }

}
//private class TransactionMapper implements RowMapper<Transactions>{
//    @Override
//     public Transactions mapRow(R)
//    Transactions transactions=new Transactions();
//
//}

