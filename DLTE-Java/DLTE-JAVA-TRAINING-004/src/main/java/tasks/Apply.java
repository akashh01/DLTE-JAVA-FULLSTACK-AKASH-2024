package tasks;

public class Apply {
    public static void main(String[] args) {
        //customer using thw debit card feature
        DebitCard[] customers=new DebitCard[10];
        customers [0]=new DebitCard(822522222L,5000L,"Akash",4545544545L,5244);
        customers[0].withdraw();
        //customer using the google pay feature
        Gpay OnlineCustomer[]=new Gpay[10];
        OnlineCustomer[0]=new Gpay(822522322L,5000L,"Aamir","AAKASH",5222);
        OnlineCustomer[0].payBills("Ajay",545L,"Commercial");
    }
}
