package org.example;

public class ExecuteGenirics {
    public static void main(String[] args) {
        GeniricApi<Profile> profileGeniricApi=new GeniricApi<>();
        GeniricApi<Integer> integerGenericAPI=new GeniricApi<>();

        Profile profile1=new Profile("Akash","akash1234","Kannur,Kerala",87847847847L);
        Profile profile2=new Profile("Ajay","ajay1234","Kannur,kerala",7878787878L);

        profileGeniricApi.myObjects=new Profile[3];
        profileGeniricApi.insertNewRecords(profile1);
        profileGeniricApi.insertNewRecords(profile2);
        System.out.println(profileGeniricApi.read(1));
         //intializing the integer values myobject size initially then adding records to it,the myObjects is in abstract class with no size mentioned in it
        integerGenericAPI.myObjects=new Integer[20];
        integerGenericAPI.insertNewRecords(2);
        integerGenericAPI.insertNewRecords(9);
        System.out.println(integerGenericAPI.read(1));
    }
}