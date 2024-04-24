package loanlogic;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean
@RequestScoped
public class Loans {
    private Long loanNumber;
    private Double loanAmount;
    private String loanDate;
    private String loanStatus;
    private String borrowerName;
    private Long borrowerContact;
    private List<Loans> loanList;

    @PostConstruct
    public void initLoans() {
        loanList = new ArrayList<>();
        loanList.add(new Loans(123456L, 3453.9, "03/03/2024", "open", "ajay", 2435435432L));
        loanList.add(new Loans(654123L, 3454353.9, "05/03/2024", "closed", "amal", 2435435432L));
        loanList.add(new Loans(789654L, 3453423.9, "06/03/2024", "closed", "aneesh", 2435435432L));
        loanList.add(new Loans(7955555L, 34523453.9, "07/03/2024", "open", "anek", 2435435432L));
    }


    public void addLoan(Loans loan) {
        loanList.add(loan);
    }

    public Loans() {
    }

    public List<Loans> getClosedLoans() {
        List<Loans> closedLoans = new ArrayList<>();
        for (Loans loan : loanList) {
            if (loan.getLoanStatus().equalsIgnoreCase("closed")) {
                closedLoans.add(loan);
            }
        }
        return closedLoans;
    }

    public void deleteLoan(Long loanNumber) {
        loanList.removeIf(loan -> loan.getLoanNumber().equals(loanNumber));
    }
    public String loanall(){
        return loanList.toString();
    }


    @Override
    public String toString() {
        return "Loans{" +
                "loanNumber=" + loanNumber +
                ", loanAmount=" + loanAmount +
                ", loanDate='" + loanDate + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowerContact=" + borrowerContact +
                '}';
    }


    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
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

    public Loans(Long loanNumber, Double loanAmount, String loanDate, String loanStatus, String borrowerName, Long borrowerContact) {
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.loanStatus = loanStatus;
        this.borrowerName = borrowerName;
        this.borrowerContact = borrowerContact;
    }




}
