package store.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    private Date dateOfTransaction;
    private Integer amountInTransaction;
    private String toWhom;
    private String remarks; //Family, Education, Emergency, Bills, Friend

}
