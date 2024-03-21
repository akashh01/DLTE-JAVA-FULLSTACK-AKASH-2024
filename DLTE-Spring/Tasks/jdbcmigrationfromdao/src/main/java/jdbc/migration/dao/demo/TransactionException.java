package jdbc.migration.dao.demo;

public class TransactionException extends RuntimeException {
    public TransactionException(){
        super("Transaction Not available");
    }
    public TransactionException(String info){
        super(info+ " Credit Card Not available");

    }

}
