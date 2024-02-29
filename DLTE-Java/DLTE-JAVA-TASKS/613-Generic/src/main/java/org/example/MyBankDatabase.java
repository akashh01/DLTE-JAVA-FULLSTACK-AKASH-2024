package org.example;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyBankDatabase<T> implements Activity<T> {
    T[] bankDataBase;
    @Override
    public String createNewData(T object) {
            int size=bankDataBase.length;
            for(int index=0;index<size;index++){
                if(bankDataBase[index]==null){
                    bankDataBase[index]=object;
                    return "credit card details has been added";
                   // break;
                }
            }throw new BankException();

            //return " object not added ";
    }


    @Override
    public T readData(int position) {
        int size=bankDataBase.length;
       if(position>=0&&position<size){
           //System.out.println(bankDataBase[position]);
          return bankDataBase[position];
        }
        return null;
    }

    @Override
    public void updateData(int position, T object) {
        int size=bankDataBase.length;
        if(position>=0&&position<size){
            bankDataBase[position]=object;
            return;
        }

    }

    @Override
    public String deleteData(int position) {
        int size=bankDataBase.length;
        Object obj=null;
        if(position>=0&&position<size){
            obj=bankDataBase[position];
            bankDataBase[position]=null;
            return obj +" deleted";
        }
        throw new BankException();
    }
}
//Generic classes gives object , if object has getters and setter can we access them?