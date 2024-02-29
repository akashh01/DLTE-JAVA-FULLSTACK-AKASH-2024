package org.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
        ArrayList newArray=new ArrayList<>();
        newArray.add("hello");
        newArray.add(23);
        System.out.println(newArray.get(0));
    }
}
