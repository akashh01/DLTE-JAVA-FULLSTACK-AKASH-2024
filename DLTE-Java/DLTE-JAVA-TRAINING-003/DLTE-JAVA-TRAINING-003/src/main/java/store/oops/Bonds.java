package store.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.activation.ActivationGroup;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bonds {
    //features of bonds
    private Integer maturity;
    private Double InterestRate;
    private String taxStatus;
    private Integer period;//their tax status, bondholder, period

    public static void main(String[] args) {
        //defining 5 different bonds
        Bonds Government_bond= new Bonds(5,7.2,"No tax",5);
        Bonds Corporate_bond= new Bonds(5,9.2,"No tax",5);
        Bonds Municiple_bond= new Bonds(5,12.5,"No tax",5);
        Bonds Agency_bond= new Bonds(5,5.5,"No tax",5);
        Bonds Private_bond= new Bonds(5,6.0,"No tax",5);
        Bonds bonds[]={Government_bond,Corporate_bond,Municiple_bond, Agency_bond,Private_bond};
        int position= MaximumReturn(bonds);
     //   System.out.println(bonds[position]);
    }
     //Maximum Interests
    public static int MaximumReturn(Bonds[] bonds){
        double maximumIntrest=0;
        int postion=0,count=0;
        for(Bonds each:bonds){
            count++;
            if(each.getInterestRate()>maximumIntrest){
                maximumIntrest=each.getInterestRate();
                postion=count;
            }
        }
        System.out.println("The maximum intrest rate is "+maximumIntrest);
        return postion;
    }


}
