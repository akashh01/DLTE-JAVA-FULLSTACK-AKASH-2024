package sets;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class IllustrationSets {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>(1);
        linkedHashSet.add(98);linkedHashSet.add(120);linkedHashSet.add(45);
        linkedHashSet.add(1116);linkedHashSet.add(5);

        HashSet<Integer> hashSet=new HashSet<>(linkedHashSet);
        TreeSet<Integer> treeSet=new TreeSet<>();treeSet.addAll(linkedHashSet);

        System.out.println(linkedHashSet);
        linkedHashSet.forEach(System.out::println);
        System.out.println("Hashset");
       // hashSet.forEach(System.out::println);
        System.out.println(hashSet);
        System.out.println("TREE SET");
        System.out.println(treeSet);
    }
}
