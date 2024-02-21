package store.oops;

import java.util.Date;
import java.util.Scanner;

import static java.lang.System.exit;

public class TransactionAnalysis{
    public static void main(String[] args) {
        Transactions[] transactions={
                new Transactions(new Date(2021,8,24),500,"Ajay","Friend"),
                new Transactions(new Date(2020,9,12),5000,"Deepansh","Family"),
                new Transactions(new Date(2022,8,03),6500,"Akash","Education"),
                new Transactions(new Date(2024,5,15),7000,"Current","Bills"),
                new Transactions(new Date(2021,8,24),50000,"Ajay","Friend"),
        };
       TransactionAnalysis customerAnalyis=new TransactionAnalysis();
        int choice;
        Scanner scanner = new Scanner(System.in);
        //menu for transaction analysis
        while (true) {
            System.out.println("----------TRANSACTION ANALYSIS------------");
            System.out.println("Choose 1 for least amount transferred\n" + "Choose 2 for transaction to particular beneficiary\n" + "Choose 3 for filtering based on particular remark\n" + "Choose 4 sort in descendin based on beneficiary \n"+"Choose 5  to sort based on amount transferred ascending\n"+ "Choose 6 to identify maximum transaction");
            choice = scanner.nextInt();
            CreditCardAnalysis analysis = new CreditCardAnalysis();
            switch (choice) {
                case 1:
                    customerAnalyis.leastAmountTransferred(transactions);
                case 2:
                    customerAnalyis.transactionToParticularBeneficiary(transactions);
                case 3:
                    customerAnalyis.FilteringBasedParticularRemark(transactions);
                case 4:
                    customerAnalyis.SortBeneficiary(transactions);
                case 5:
                    customerAnalyis.SortAmount(transactions);
                case 6:
                    customerAnalyis.MaxAmountTransferred(transactions);

            }
        }
    }
    //range of transaction based on dates
    public void RangeBasedOnDates(Transactions[] transactions){
        String StartDateInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start range date dd/mm/yyyy format");
        StartDateInput=scanner.next();
        String splitStartDate[]=StartDateInput.split("/");
        for(Transactions each: transactions){
            if((Integer.parseInt(splitStartDate[0])==(each.getDateOfTransaction()).getDate())&&(Integer.parseInt(splitStartDate[1])==(each.getDateOfTransaction()).getMonth())&&(Integer.parseInt(splitStartDate[2])==(each.getDateOfTransaction()).getYear())) {
                System.out.println("Transaction on date "+(each.getDateOfTransaction()).getDate()+"to"+each.getToWhom());
                System.out.println(each.getAmountInTransaction());
            }

        }

    }
    //least money transferred by the person
    public void leastAmountTransferred(Transactions[] transactions){
        int leastAmounts=Integer.MAX_VALUE;
        for(Transactions each:transactions){
            int compareAmount=each.getAmountInTransaction();
            if(compareAmount<leastAmounts){
                 leastAmounts=compareAmount;
            }
        }
        System.out.println("The least amount transfered is "+leastAmounts);
    }

    //maximum money transferred by the person
    public void MaxAmountTransferred(Transactions[] transactions){
        int MaxAmounts=Integer.MIN_VALUE;
        for(Transactions each:transactions){
            int compareAmount=each.getAmountInTransaction();
            if(compareAmount>MaxAmounts){
                MaxAmounts=compareAmount;
            }
        }
        System.out.println("The maximum amount transfered is "+MaxAmounts);
    }
    //transaction to particular beneficiary
    public void transactionToParticularBeneficiary(Transactions[] transactions){
        Scanner scanner=new Scanner(System.in);
        String Beneficiary;
        System.out.println("Enter beneficiary name");
        Beneficiary= scanner.next();
        int NumberOfTransaction=0;
        for(Transactions each:transactions){
            if(each.getToWhom().equals(Beneficiary)){
                NumberOfTransaction++;
            }

        }
        System.out.println("Number of transaction to "+Beneficiary+"= "+NumberOfTransaction);
    }
    //filtering based on particular remark in transaction
    public void FilteringBasedParticularRemark(Transactions[] transactions){
        Scanner scanner=new Scanner(System.in);
        String Remark;
        System.out.println("Enter Remark");
        Remark= scanner.next();
        for(Transactions each:transactions){
            if(each.getRemarks().equals(Remark)){
                System.out.println(each.getAmountInTransaction()+" is the amount transferred to "+each.getToWhom()+" has remark "+Remark);
            }

        }

    }
    //selection sort based on Beneficiary in descending
    public void SortBeneficiary(Transactions[] transactions){
        Transactions temporary=null;
        for(int index=0;index<transactions.length-1;index++){
            int maximumIndex=index;
            String maximumString=transactions[index].getToWhom();
            for(int next=index+1;next<transactions.length;next++){
                if(transactions[next].getToWhom().compareTo(maximumString)>0){
                    maximumString=transactions[next].getToWhom();
                    maximumIndex=next;
                }
            }
            if(maximumIndex!=index){
                temporary=transactions[maximumIndex];
                transactions[maximumIndex]=transactions[index];
                transactions[index]=temporary;
            }
        }
    }
    //selection sort based on amount in ascending
    public void SortAmount(Transactions[] transactions){
        Transactions temporary=null;
        for(int index=0;index<transactions.length-1;index++){
            int minimumIndex=index;
            int minimumAmount=transactions[index].getAmountInTransaction();
            for(int next=index+1;next<transactions.length;next++){
                if(transactions[next].getAmountInTransaction()<minimumAmount){
                    minimumAmount=transactions[next].getAmountInTransaction();
                    minimumIndex=next;
                }
            }
            if(minimumIndex!=index){
                temporary=transactions[minimumIndex];
                transactions[minimumIndex]=transactions[index];
                transactions[index]=temporary;
            }
        }
    }



}


