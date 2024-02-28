package org.example;

public class Test {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args)  {
        Test app[] = new Test[4];
     //   app[0].setAddress("ADDRESS");
        System.out.println(app.length);
        System.out.println(app[0]);
        try{
            System.out.println(app[1].getAddress());
        }
        catch (NullPointerException exception){
            System.out.println("You have a null pointer exception "+exception);

        }
//    public void testMethod(){
//        String name;
//        System.out.println("hello !");
//    }

    }
}
