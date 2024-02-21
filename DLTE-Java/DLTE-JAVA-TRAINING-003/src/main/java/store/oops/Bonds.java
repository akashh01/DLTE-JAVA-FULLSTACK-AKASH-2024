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
    private String BondName;
    private Integer maturity;
    private Double InterestRate;
    private String taxStatus;
    private Integer period;//their tax status, bondholder, period

    public static void main(String[] args) {
        //defining 5 different bonds
        Bonds bonds[]={
                new Bonds("Government bond",5,7.2,"No tax",5),
                new Bonds("Corporate bond",5,12.5,"No tax",5),
                new Bonds("Municiple bond",5,5.5,"No tax",5),
                new Bonds("Agency bond",5,6.0,"No tax",8),
                new Bonds("Agency bond",5,9.0,"tax of 10%",7)
      };
        int position= MaximumReturn(bonds);
     //   System.out.println(bonds[position]);
    }
     //Maximum Interests
    public static int MaximumReturn(Bonds[] bonds){
        double maximumIntrest=0;
        String bondName="";
        int postion=0,count=0;
        for(Bonds each:bonds){
            count++;
            if(each.getInterestRate()>maximumIntrest){
                maximumIntrest=each.getInterestRate();
                bondName=each.getBondName();
                postion=count;
            }
        }
        System.out.println("The maximum intrest rate is "+maximumIntrest+ " for the "+bondName);
        return postion;
    }


}
