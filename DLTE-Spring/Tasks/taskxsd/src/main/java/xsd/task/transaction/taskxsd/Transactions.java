package xsd.task.transaction.taskxsd;



public class Transactions {
    private Long transactionId;
    private String transactionDate;
    private String transactionBy;
    private String transactionTo;
    private Long transactionAmount;
    private String transactionFor;

    public Transactions() {
    }

    public Transactions(Long transactionId, String transactionDate, String transactionBy, String transactionTo, Long transactionAmount, String transactionFor) {
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

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
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
