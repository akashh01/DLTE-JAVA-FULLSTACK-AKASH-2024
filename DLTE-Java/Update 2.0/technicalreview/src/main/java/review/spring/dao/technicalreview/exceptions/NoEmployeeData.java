package review.spring.dao.technicalreview.exceptions;


import java.util.ResourceBundle;

public class NoEmployeeData extends RuntimeException{
    public NoEmployeeData() {
        super(ResourceBundle.getBundle("application").getString("no.data"));
    }
}