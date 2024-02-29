package org.example;

public class GeniricApi<T> extends MyBankCrudActivity<T> {
//the the class genericApp can be without <T>,but then we will not be able to use in the T inside the methods,and in the body of the class,
//advantage of generic classes it will give complie time exception check and also it is reusable for various purposes
    @Override
    public String insertNewRecords(T objects) {
        for(int index=0;index<myObjects.length;index++){
            if(myObjects[index]==null){
                myObjects[index]=objects;
                break;
            }

        }
        return objects+ " has been sucessfully inserted";
    }

    @Override
    public T read(int index) {
        if (index>=0&&index<myObjects.length){
            return myObjects[index] ;
        }
        return null;
    }

    @Override
    public String delete(int index) {
        if(index>=0&&index<myObjects.length&&myObjects[index]!=null){
            T object =myObjects[index];
            myObjects[index]=null;
            return object + "has been deleted";
        }
        return null;
    }

    @Override
    public void update(int index, T object) {
        if(index>=0&&index< myObjects.length){
            myObjects[index]=object;
            System.out.println(object+" has updated @ "+index);
        }
        else
            System.out.println(object+" hasn't updated @ "+index);
    }
}

