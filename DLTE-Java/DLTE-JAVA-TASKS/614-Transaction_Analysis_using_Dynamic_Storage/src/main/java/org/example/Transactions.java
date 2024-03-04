package org.example;

import java.util.Date;

public class Transactions {

    private Date dateOfTransaction;
    private Integer amountInTransaction;
    private String toWhom;
    private String remarks; //Family, Education, Emergency, Bills, Friend

    @Override
    public String toString() {
        return "Transactions{" +
                "dateOfTransaction=" + dateOfTransaction +
                ", amountInTransaction=" + amountInTransaction +
                ", toWhom='" + toWhom + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Transactions() {
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public Integer getAmountInTransaction() {
        return amountInTransaction;
    }

    public void setAmountInTransaction(Integer amountInTransaction) {
        this.amountInTransaction = amountInTransaction;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Transactions(Date dateOfTransaction, Integer amountInTransaction, String toWhom, String remarks) {
        this.dateOfTransaction = dateOfTransaction;
        this.amountInTransaction = amountInTransaction;
        this.toWhom = toWhom;
        this.remarks = remarks;
    }
}
