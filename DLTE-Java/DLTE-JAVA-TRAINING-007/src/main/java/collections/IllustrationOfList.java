package collections;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//arrayList
//to add -> add,addAll,add(pos,obj)
//to read -> get method
//contains ->true/false
public class IllustrationOfList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(12);
        arrayList.add("Hello");  //non generic
        System.out.println(arrayList);

        ArrayList<String> stringList = new ArrayList<>(2);
        stringList.add("hello");
        String depostis1 = "Fixed";
        String deposit2 = "RD";
        stringList.add(depostis1);
        stringList.add(deposit2);
        stringList.add("third element"); //though arraylist is initilaized with 2 elements it can add mkre elemetn
        //method reference
        stringList.forEach(System.out::println);
        System.out.println("second element is " + stringList.get(2));
        System.out.println("Index of 'Fixed' is " + stringList.indexOf("Fixed"));
        stringList.remove("hello");
        System.out.println("After removing one element");
        stringList.forEach(System.out::println);
        stringList.set(2, "new element");   //to replace the element in a given index
        System.out.println("size of array list is " + stringList.size());
        //isEmpty,removeAll,toArray are other methods


        //vector
        System.out.println("Welcome to vectors");
        Vector<Double> tryVector = new Vector<>();
        tryVector.add(9.1);
        tryVector.add(2.2);
        tryVector.add(3.3);    //addAll with input parameter collection can be used
        Collections.sort(tryVector);  //sorting method in collection
        tryVector.forEach(each -> System.out.println(each));
        System.out.println("The max element is " + Collections.max(tryVector)); //max and min mehtod
        //using iterator
        Vector<String> stringVector = new Vector<>();
        stringVector.addAll(stringList);            ////adding the entire colllection of array list to vector
        ///iterators in collections,works similiar to that of the for eac ,point out nect vlaure
        //also ListIterators -> hasPrevious,hasNext both the collections
        Iterator<String> stringIterator = stringVector.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }


        ///linked list
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Orange");
        linkedList.add("Gauva");
        System.out.println(linkedList);
        linkedList.add(2,"Watermelon");
        System.out.println(linkedList);
        linkedList.removeFirst(); //same works for removeLast() and also remove(specific)
        System.out.println(linkedList);


        //lambda
//         stringvector.forEach(item-> System.out.println(item));
//
//         for(int index=0;index<stringlist.size();index++){
//             System.out.println(stringlist.get(index));
//         }
//         //account obj=new debt();
//        List<Integer> integerList=new ArrayList<>();
//         integerList.add(12);integerList.add(50);
//        System.out.println(integerList.get(0));


    }}

