package jdbc.migration.dao.demo;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Transactions {
    @NotNull(message = "{not.empty}")
    private Long transactionId;
    @NotNull(message = "{not.empty}")
    private Date transactionDate;
    @NotNull(message = "{not.empty}")
    private String transactionBy;
    @NotNull(message = "{not.empty}")
    private String transactionTo;
    @NotNull(message = "{not.empty}")
    private Long transactionAmount;
    @NotNull(message = "{not.empty}")
    private String transactionFor;

    public Transactions() {
    }

    public Transactions(Long transactionId, Date transactionDate, String transactionBy, String transactionTo, Long transactionAmount, String transactionFor) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionBy = transactionBy;
        this.transactionTo = transactionTo;
        this.transactionAmount = transactionAmount;
        this.transactionFor = transactionFor;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionBy() {
        return transactionBy;
    }

    public void setTransactionBy(String transactionBy) {
        this.transactionBy = transactionBy;
    }

    public String getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(String transactionTo) {
        this.transactionTo = transactionTo;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionFor() {
        return transactionFor;
    }

    public void setTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
    }
}
