package loan.dao.project.loan.exceptions;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class NoLoanData extends RuntimeException {
    public NoLoanData(){
        super("errer");
    }

}
