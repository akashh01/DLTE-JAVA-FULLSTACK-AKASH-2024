package inheritance.training;

public interface Repositeries {
    //SavingsAccount[] myBank=new SavingsAccount[10];
    //what you can do with the class can be done to interface properties

    //absrtact method and non abstract method
   //cant create public void viewAll(){}
    //static and default can be used for method with body
    ///default can be used for within the class

    //interface does not have a constructor
    //by default the data members in interface is finall
    //for an array defined within the classs we can change the size by addding items
    //we can do overloading in interface

    //Casting can happen between classs

    //if we have multiple interface mentioned , it will go based on fifo. overrride whatever you wanted
    // multiple inheritance in terms of class not present,

    SavingsAccount[] myBank=new SavingsAccount[10]; // property
//    public void viewAll();// abstract method

    default void initialize(){
        myBank[0]=new SavingsAccount("Razak Mohamed S",65456789L,12990.4);
        myBank[1]=new SavingsAccount("Arun Rajpurohit",5672893454L,89333.3);
        myBank[2]=new SavingsAccount("Sridhar Moorthi",876545678L,98434544.4);
    }
    default void listAll(){
        for(SavingsAccount each:myBank){
            System.out.println(each);
        }
    }

    static void listFew(){
        for(SavingsAccount each:myBank){
            if(each!=null&&each.getAccountBalance()>=10000)
                System.out.println(each);
        }
    }
}

class NetBanking{
    //public abstract void profile();
    SavingsAccount[] ourBank=new SavingsAccount[10];
}