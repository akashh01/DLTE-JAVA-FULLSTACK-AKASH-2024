package loan.dao.project.loan.entities;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class LoanAvailable {
    //Entites
    @NotNull(message = "{EXV001}")
    @Positive(message ="{EXV002}")
    @Digits(integer = 3, fraction = 0, message = "{EXV003}")
    private long loanNumber;
    @NotNull(message = "{EXV001}")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "{EXV004}")
    private String loanType;
    @NotNull(message = "{EXV001}")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "{EXV004}")
    private String loanName;
    @NotNull(message = "{EXV001}")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "{EXV004}")
    private String loanDescription;
    @NotNull(message = "{EXV001}")
    @Positive(message ="{EXV002}")
    @Digits(integer = 8, fraction = 2, message = "{EXV002}")
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

    @Override
    public String toString() {
        return "LoanAvailable{" +
                "loanNumber=" + loanNumber +
                ", loanType='" + loanType + '\'' +
                ", loanName='" + loanName + '\'' +
                ", loanDescription='" + loanDescription + '\'' +
                ", loanRoi=" + loanRoi +
                '}';
    }
}
