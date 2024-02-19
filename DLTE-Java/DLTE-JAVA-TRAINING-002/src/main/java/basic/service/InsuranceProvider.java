package basic.service;

import java.util.HashMap;
import java.util.List;

public class InsuranceProvider {
    public static void main(String [] myInsurences) {
             for(int index=0;index<myInsurences.length;index++){
                 System.out.print("Required features of insurance "+myInsurences[index]);
             }
             //death benifit, Sum assured,Laon option,Achieve Child Goals, Safer Retirement,Value of risk,large number of insured person,Surrender value,Tax benifits
             String[] bajaj ={"Sum assured","Loan option","Safer Retirement"};
             String[] ecdc={"Value of risk","large number of insured person","Surrender value"};
             String[] hdfc={"Tax benifits","Sum assured","Achieve Child Goals"};
             String[] lic={"large number of insured person","Safer Retirement","Tax benifits"};
             int match[]={0,0,0,0};
            //calculating matching features from user requirements and incrementing the
            for(int index=0;index<myInsurences.length;index++){
                for(int index1=0;index1<3;index1++){{
                    if(myInsurences[index].equals(bajaj[index1])){
                        match[0]++;
                    }
                    if(myInsurences[index].equals(ecdc[index1])){
                        match[1]++;
                    }
                    if(myInsurences[index].equals(hdfc[index1])){
                        match[2]++;
                    }
                    if(myInsurences[index].equals(lic[index1])){
                        match[3]++;
                    }
                }
                }
            }

            int maxValue=Integer.MIN_VALUE,returnIndex=-1;
            for(int index=0;index<4;index++){
                 if(match[index]>=maxValue)
                 {

                     maxValue=match[index];
                     returnIndex=index;

                 }
            }
            if(returnIndex==0){
                System.out.println("The best insurance for you is bajaj insurance");
            }
            else if(returnIndex==1){
                System.out.println("The best insurance for you is ecdc insurance");
            }
            else if(returnIndex==2){
                System.out.println("The best insurance for you is hdfc insurance");
            }
            else {
                System.out.println("The best insurance for you is lic insurance");
            }


    }
}
//             for(int index=0;index<myInsurences.length;index++){
//                 if(bajaj.equals(myInsurences[index])){
//                     match[0]=match[0]+1;
//                     System.out.println(match[0]);
//                 }
//             }
//            HashMap<String,Integer> map= new HashMap<>();
//            map.put("bajaj",0);
//            map.put("ecdc",0);
//            map.put("hdfc",0);
//            map.put("lic",0);
