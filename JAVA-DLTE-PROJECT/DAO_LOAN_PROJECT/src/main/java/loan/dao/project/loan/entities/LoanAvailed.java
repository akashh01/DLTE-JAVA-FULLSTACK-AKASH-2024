package loan.dao.project.loan.entities;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoanAvailed {
    @NotNull(message="{loan.avail.num.null}")
    @Digits(integer = 3,fraction = 0, message = "{loan.num.invalid}")
    private int loanAvailNumber;
    @NotNull(message="{loan.customer.num.null}")
    @Digits(integer = 3,fraction = 0, message = "{loan.num.invalid}")
    private int customerNumber;
    @NotNull(message="{loan.num.null}")
    @Digits(integer = 3,fraction = 0, message = "{loan.num.invalid}")
    private long loanNumber;
    @NotNull(message="{loan.amount.null}")
    @Digits(integer = 10,fraction=0,message="{loan.amount.null}")
    private long loanAmount;
    @NotNull(message="{loan.emi.null}")
    @Digits(integer = 2,fraction = 2,message="{loan.emi.null}")
    private double loanEmi;
    @NotNull(message="{loan.tenure.null}")
    @Digits(integer = 2,fraction = 0,message="{loan.tenure.null}")
    private int loanTenure;

    public LoanAvailed() {
    }

    public LoanAvailed(@NotNull(message = "{loan.customer.num.null}") @Digits(integer = 3, fraction = 0, message = "{loan.num.invalid}") int customerNumber, @NotNull(message = "{loan.num.null}") @Digits(integer = 3, fraction = 0, message = "{loan.num.invalid}") long loanNumber, @NotNull(message = "{loan.amount.null}") @Digits(integer = 10, fraction = 0, message = "{loan.amount.null}") long loanAmount, @NotNull(message = "{loan.emi.null}") @Digits(integer = 2, fraction = 2, message = "{loan.emi.null}") double loanEmi, @NotNull(message = "{loan.tenure.null}") @Digits(integer = 2, fraction = 0, message = "{loan.tenure.null}") int loanTenure) {
        this.customerNumber = customerNumber;
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.loanEmi = loanEmi;
        this.loanTenure = loanTenure;
    }

    public int getLoanAvailNumber() {
        return loanAvailNumber;
    }

    public void setLoanAvailNumber(int loanAvailNumber) {
        this.loanAvailNumber = loanAvailNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanEmi() {
        return loanEmi;
    }

    public void setLoanEmi(double loanEmi) {
        this.loanEmi = loanEmi;
    }

    public int getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(int loanTenure) {
        this.loanTenure = loanTenure;
    }
}
