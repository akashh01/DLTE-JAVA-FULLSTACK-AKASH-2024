package org.example;

public interface Activity<T> {
    //public void create
    //T[] objectItems;
    String createNewData(T object);
     T readData(int accNumber);
     void updateData(int index,T object);
     String deleteData(int index);

 //    can i speak about my journey to tietoevry and and my short experience about being here ?
}
