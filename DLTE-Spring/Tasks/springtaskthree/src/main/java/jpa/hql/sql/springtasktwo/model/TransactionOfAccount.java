package jpa.hql.sql.springtasktwo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class TransactionOfAccount {
    @Id
    private Long transactionId;
    private String username;
    private Long accountId;
    private Long amount;
    private String transactionType; //deposit,withdraw

    public TransactionOfAccount() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionOfAccount(Long transactionId, String username, Long accountId, Long amount, String transactionType) {
        this.transactionId = transactionId;
        this.username = username;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
    }
}
