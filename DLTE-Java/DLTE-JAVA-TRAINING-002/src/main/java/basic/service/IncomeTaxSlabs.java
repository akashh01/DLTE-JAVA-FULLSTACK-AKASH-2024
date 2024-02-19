package basic.service;
import java.util.*;

import static java.lang.System.exit;

public class IncomeTaxSlabs {
    public static void main(String[] args) {
        Long annualIncome=0L;
        double taxAmount;
        int regime;
        Scanner sc=new Scanner(System.in);
        //getting annual income for calculating tax
        System.out.println("Enter your annual income");
        annualIncome=sc.nextLong();
        System.out.println("Enter 1 for old regime\nEnter 2 for new regime ");
        regime=sc.nextInt();
        switch(regime){
            //for income slabs based on old tax slab
            case 1:
                    if (annualIncome<=250000){
                      System.out.println("No tax required to pay");
                    }
                    else if(annualIncome>250000 & annualIncome<=500000){
                      System.out.println("You have to pay an tax of 5%");
                      taxAmount=annualIncome*0.05;
                      System.out.println("Tax amount ="+taxAmount);
                    }
                    else if(annualIncome>50000 & annualIncome<=1000000){
                      System.out.println("You have to pay an tax of 20%");
                      taxAmount=annualIncome*0.2;
                      System.out.println("Tax amount ="+taxAmount);
                    }
                    else {
                      System.out.println("You have to pay an tax of 30%");
                      taxAmount=annualIncome*0.3;
                      System.out.println("Tax amount ="+taxAmount);
                    }
                    break;
            case 2:
                //for income tax based on new tax slab
                   if (annualIncome<=300000){
                     System.out.println("No tax required to pay");
                   }
                   else if(annualIncome>=300001 & annualIncome<=600000){
                     System.out.println("You have to pay an tax of 5%");
                     taxAmount=annualIncome*0.05;
                     System.out.println("Tax amount ="+taxAmount);
                   }
                   else if(annualIncome>=600001 & annualIncome<=900000){
                     System.out.println("You have to pay an tax of 10%");
                     taxAmount=annualIncome*0.1;
                     System.out.println("Tax amount ="+taxAmount);
                   }
                   else if(annualIncome>=900001 & annualIncome<=1200000){
                     System.out.println("You have to pay an tax of 15%");
                     taxAmount=annualIncome*0.15;
                     System.out.println("Tax amount ="+taxAmount);
                   }
                   else if(annualIncome>=1200001 & annualIncome<=1500000){
                     System.out.println("You have to pay an tax of 20%");
                     taxAmount=annualIncome*0.2;
                     System.out.println("Tax amount ="+taxAmount);
                   }
                   else{
                     System.out.println("You have to pay an tax of 30%");
                     taxAmount=annualIncome*0.3;
                     System.out.println("Tax amount ="+taxAmount);
                   }
                   break;
             //if any other entry exit out of the loop
            default: exit(0);
        }
    }
}
