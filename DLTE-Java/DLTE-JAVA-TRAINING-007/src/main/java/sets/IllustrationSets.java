package sets;

import java.sql.SQLOutput;
import java.util.*;

public class IllustrationSets {
    public static void main(String[] args) {
       HashSet<String> set=new HashSet<>();
        ArrayList<String> stringList = new ArrayList<>(2);
        stringList.add("hello");
        stringList.add("Fixed");
        stringList.add("RD");
        //adding the entire array list collection to hashset
        set.addAll(stringList);
        System.out.println(set); //NOT THE SAME ORDER AS ELMENT WAS ADDED!
        set.clear();
        System.out.println("The size after reemoving all "+ set.size());
        Collections.sort(stringList);
        System.out.println("sorted list is "+ stringList);
        stringList.set(2,"check");
        System.out.println(stringList);

        //Linked list
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>(1);//again dynamic size
        linkedHashSet.add(1);linkedHashSet.add(2);linkedHashSet.add(3);
        linkedHashSet.add(4);linkedHashSet.add(5);
        System.out.println(linkedHashSet); //maintains the order in which it was entered

        //TreeSet
        TreeSet<Integer> treeSet=new TreeSet<>();treeSet.addAll(linkedHashSet);
        treeSet.remove(1);
         System.out.println("hash code value "+ treeSet.hashCode());  //bucket location to store the value
        System.out.println("TREE SET");
        System.out.println(treeSet);
    }
}
