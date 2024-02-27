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
        Bonds bonds[] = {
                new Bonds("Government bond", 5, 1.2, "No tax", 5),
                new Bonds("Corporate bond", 5, 12.5, "No tax", 5),
                new Bonds("Municiple bond", 5, 5.5, "No tax", 5),
                new Bonds("Agency bond", 5, 6.0, "No tax", 8),
                new Bonds("Agency bond", 5, 9.0, "tax of 10%", 7)
        };
       // int position = MaximumReturn(bonds);
        MaximumReturn(bonds);
        //   System.out.println(bonds[position]);
    }

    //Maximum Interests
    public static void MaximumReturn(Bonds[] bonds) {
        double maximumIntrest = 0;
        Bonds newBond = null;
       // int maxPositon = 0;
        for (int index =0;index<bonds.length-1;index++) {
            maximumIntrest = bonds[index].getInterestRate();
            int maxPositon=index;
            for (int next=index+1; next<bonds.length; next++) {
                if (maximumIntrest < bonds[next].getInterestRate()) {
                    maximumIntrest = bonds[next].getInterestRate();
                    maxPositon = next;
                }
            }
                if (maxPositon!=index) {
                    newBond=bonds[maxPositon];
                    bonds[maxPositon]=bonds[index];
                    bonds[index]=newBond;
                }


        }
        for (Bonds each : bonds) {
            System.out.println(each.getInterestRate());
        }
    }
}





