package collections;

import genirics.example.DebitCard;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.TreeSet;

public class IllustrationMaps {
    public static void main(String[] args) {
        Hashtable<String, Double> hashExample = new Hashtable<>();
        hashExample.put("Akash", 1000.1);
        hashExample.put("Ahan", 1999.1);
        hashExample.put("Amal", 1899.1);
        System.out.println(hashExample);
        System.out.println(hashExample.get("Akash"));

        //tree map with object
        TreeMap<Integer,DebitCard> debitMap=new TreeMap<>();
        DebitCard debitCard1=new DebitCard(994464554l,"Akash",455,4654);
        DebitCard debitCard2=new DebitCard(884464554l,"Ajay",655,8654);
        debitMap.put(1,debitCard1);
        debitMap.put(2,debitCard2);
        System.out.println("tree : " +debitMap.get(2).getHolderName());

        //try with hashMap
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(1,"Ajay");
        hashMap.put(2,"Akshay");

        //printing with for each
        for(HashMap.Entry<Integer,String> hm:hashMap.entrySet()){
            System.out.print(hm.getKey() +":");
            System.out.println(hm.getValue());
        }

    }}