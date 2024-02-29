package org.example;

import java.util.Arrays;

public abstract class MyBankCrudActivity<T>{
    //the layout for creating generic methods,object ,the genircs can be parameters in method,return type of the method or objects
    T[] myObjects;
    public abstract String insertNewRecords(T objects);
    public void viewAll(){
        System.out.println(Arrays.toString(myObjects));
    }

    public abstract T read(int index);
    public abstract String delete(int index);
    public abstract void update(int index,T object);


}
