package loan.dao.project.loan.entities;

import org.springframework.data.relational.core.sql.In;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoanAvailed {
    @Digits(integer = 3, fraction = 0, message = "{loan.avail.invalid}")
    private Integer loanAvailNumber;
   // @NotNull(message = "{loan.customer.num.null}")
    @Digits(integer = 3, fraction = 0, message = "{loan.customer.invalid}")
    private Integer customerNumber;
    @NotNull(message = "{loan.num.null}")
    @Digits(integer = 3, fraction = 0, message = "{loan.num.invalid}")
    private Long loanNumber;
    @NotNull(message = "{loan.amount.null}")
    @Digits(integer = 10, fraction = 0, message = "{loan.amount.null}")
    private Long loanAmount;
    @NotNull(message = "{loan.emi.null}")
    @Digits(integer = 8, fraction = 2, message = "{loan.emi.null}")
    private Double loanEmi;
    @NotNull(message = "{loan.tenure.null}")
    @Digits(integer = 2, fraction = 0, message = "{loan.tenure.null}")
    private Integer loanTenure;

    public LoanAvailed() {
    }

    public LoanAvailed(@NotNull(message = "{loan.customer.num.null}") @Digits(integer = 3, fraction = 0, message = "{loan.num.invalid}") Integer customerNumber, @NotNull(message = "{loan.num.null}") @Digits(integer = 3, fraction = 0, message = "{loan.num.invalid}") Long loanNumber, @NotNull(message = "{loan.amount.null}") @Digits(integer = 10, fraction = 0, message = "{loan.amount.null}") Long loanAmount, @NotNull(message = "{loan.emi.null}") @Digits(integer = 2, fraction = 2, message = "{loan.emi.null}") Double loanEmi, @NotNull(message = "{loan.tenure.null}") @Digits(integer = 2, fraction = 0, message = "{loan.tenure.null}") Integer loanTenure) {
        this.customerNumber = customerNumber;
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.loanEmi = loanEmi;
        this.loanTenure = loanTenure;
    }

    public Integer getLoanAvailNumber() {
        return loanAvailNumber;
    }

    public void setLoanAvailNumber(Integer loanAvailNumber) {
        this.loanAvailNumber = loanAvailNumber;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
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

    public Double getLoanEmi() {
        return loanEmi;
    }

    public void setLoanEmi(Double loanEmi) {
        this.loanEmi = loanEmi;
    }

    public Integer getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(Integer loanTenure) {
        this.loanTenure = loanTenure;
    }
}
