package autowire.spring.task.autowire;

public class Loan {
    //Loan: loanNumber, loanAmount, loanStatus(Open/Closed), borrowerName, borrowerContact;v
    private Long loanNumber;
    private Long loanAmount;
    private String loanStatus;
    private String loanType;
    private String borrowerName;
    private Long borrowerContact;

    @Override
    public String toString() {
        return "Loan{" +
                "loanNumber=" + loanNumber +
                ", loanAmount=" + loanAmount +
                ", loanStatus='" + loanStatus + '\'' +
                ", loanType='" + loanType + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowerContact=" + borrowerContact +
                '}';
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Long getBorrowerContact() {
        return borrowerContact;
    }

    public void setBorrowerContact(Long borrowerContact) {
        this.borrowerContact = borrowerContact;
    }

    public Loan(Long loanNumber, Long loanAmount, String loanStatus, String loanType, String borrowerName, Long borrowerContact) {
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.loanStatus = loanStatus;
        this.loanType = loanType;
        this.borrowerName = borrowerName;
        this.borrowerContact = borrowerContact;
    }
}
