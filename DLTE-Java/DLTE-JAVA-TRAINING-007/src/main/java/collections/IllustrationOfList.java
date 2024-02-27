package collections;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//1
//to add -> add,addAll,add(pos,obj)
//to read -> get method
//contains ->true/false
public class IllustrationOfList {
    public static void main(String[] args) {
//        ArrayList arrayList=new ArrayList();   //genirics
         ArrayList arrayList=new ArrayList(1);
        arrayList.add(12);arrayList.add("Hello");
        System.out.println(arrayList);

        ArrayList<String> stringlist=new ArrayList<>(2);
       // stringlist.add("hello");
        String depostis1="Fixed";String deposit2="RD";
        stringlist= (ArrayList<String>)Stream.of(depostis1,deposit2).collect(Collectors.toList());
        System.out.println(stringlist);
        //vector
        Vector<String> stringvector=new Vector<>(stringlist);
        //CAN BE PRINT WITH EACH

        //using iterator
//        Iterator<String> stringIterator=stringvectot.iterator();
//        while(stringIterator.hasNext()){
//            System.out.println(stringIterator.next());

        //method reference
         stringlist.forEach(System.out::println);
         //lambda
         stringvector.forEach(item-> System.out.println(item));

         for(int index=0;index<stringlist.size();index++){
             System.out.println(stringlist.get(index));
         }
         //account obj=new debt();
        List<Integer> integerList=new ArrayList<>();
         integerList.add(12);integerList.add(50);
        System.out.println(integerList.get(0));

    }
    }

