package genirics.example;

import java.util.Arrays;

public abstract class MyBankCrudActivity<T> {
    //generic array of objecst
    protected T[] myObjects;
    //generice method with argument
    public abstract String insertNewRecord(T objects);
    public void viewAll(){
        System.out.println(Arrays.toString(myObjects));
    }
    public abstract T read(int index);
    public abstract String delete(int index);
    public abstract void update(int index,T objects);

}
