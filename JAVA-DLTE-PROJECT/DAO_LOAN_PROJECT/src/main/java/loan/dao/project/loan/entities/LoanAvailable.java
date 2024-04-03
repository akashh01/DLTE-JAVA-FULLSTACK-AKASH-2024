package loan.dao.project.loan.entities;

public class LoanAvailable {
    //Entites
    private long loanNumber;
    private String loanType;
    private String loanName;
    private String loanDescription;
    private double loanRoi;

    //Constructors ,gettters and setters

    public LoanAvailable() {
    }

    public LoanAvailable(long loanNumber, String loanType, String loanName, String loanDescription, double loanRoi) {
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.loanName = loanName;
        this.loanDescription = loanDescription;
        this.loanRoi = loanRoi;
    }

    public long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanDescription() {
        return loanDescription;
    }

    public void setLoanDescription(String loanDescription) {
        this.loanDescription = loanDescription;
    }

    public double getLoanRoi() {
        return loanRoi;
    }

    public void setLoanRoi(double loanRoi) {
        this.loanRoi = loanRoi;
    }
}
