package loan.dao.project.loan.entities;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Positive;

public class LoanAvailed {
    @Digits(integer = 3, fraction = 0, message = "{EXV003}")
    @Positive(message ="{EXV002}")
    private Integer loanAvailNumber;
   // @NotNull(message = "{loan.customer.num.null}")
    @Digits(integer = 3, fraction = 0, message = "{EXV003}")
    @Positive(message ="{EXV002}")
    private Integer customerNumber;
    @NotNull(message = "{EXV001}")
    @Positive(message ="{EXV002}")
    @Digits(integer = 3, fraction = 0, message = "{EXV003}")
    private Long loanNumber;
    @NotNull(message = "{EXV001}")
    @Positive(message ="{EXV002}")
    @Digits(integer = 10, fraction = 0, message = "{EXV003}")
    private Long loanAmount;
    @NotNull(message = "{EXV001}")
    @Positive(message ="{EXV002}")
    @Digits(integer = 8, fraction = 2, message = "{EXV003}")
    private Double loanEmi;
    @NotNull(message = "{EXV001}")
    @Positive(message ="{EXV002}")
    @Digits(integer = 2, fraction = 0, message = "{EXV003}")
    private Integer loanTenure;

    public LoanAvailed() {
    }

    public LoanAvailed(Integer customerNumber,  Long loanNumber, Long loanAmount,  Double loanEmi, Integer loanTenure) {
        this.customerNumber = customerNumber;
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.loanEmi = loanEmi;
        this.loanTenure = loanTenure;
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
