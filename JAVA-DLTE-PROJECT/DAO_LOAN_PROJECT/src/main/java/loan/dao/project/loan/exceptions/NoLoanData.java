package loan.dao.project.loan.exceptions;



public class NoLoanData extends RuntimeException {
    public NoLoanData(){
        super("No data present");
    }

}
