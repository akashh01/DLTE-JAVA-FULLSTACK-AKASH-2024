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

    default void ListAll(){

    }
    //overriding within the clsddd
}
