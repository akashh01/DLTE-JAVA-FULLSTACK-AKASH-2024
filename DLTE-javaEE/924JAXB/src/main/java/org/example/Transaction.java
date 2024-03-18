package org.example;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name ="alltransaction")
public class Transaction {
    private Date dateOfTransaction;
    private Integer amountInTransaction;
    private String toWhom;
    private String remarks; //Family, Education, Emergency, Bills, Friend

    @Override
    public String toString() {
        return "Transaction{" +
                "dateOfTransaction=" + dateOfTransaction +
                ", amountInTransaction=" + amountInTransaction +
                ", toWhom='" + toWhom + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Transaction() {
    }

    public Transaction(Date dateOfTransaction, Integer amountInTransaction, String toWhom, String remarks) {
        this.dateOfTransaction = dateOfTransaction;
        this.amountInTransaction = amountInTransaction;
        this.toWhom = toWhom;
        this.remarks = remarks;
    }
    @XmlAttribute(name="date")
    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }
    @XmlElement(name="amount")
    public Integer getAmountInTransaction() {
        return amountInTransaction;
    }

    public void setAmountInTransaction(Integer amountInTransaction) {
        this.amountInTransaction = amountInTransaction;
    }
    @XmlElement(name="toWhom")
    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }
    @XmlElement(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
