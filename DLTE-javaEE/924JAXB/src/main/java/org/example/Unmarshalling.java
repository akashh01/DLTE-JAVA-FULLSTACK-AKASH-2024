package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Unmarshalling {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {


        JAXBContext context = JAXBContext.newInstance(AllTransactions.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        AllTransactions details = (AllTransactions) unmarshaller.unmarshal(new FileInputStream("Transaction.xml"));
            List<Transaction> transactions=details.getAllTransaction();
        System.out.println("Enter to whom transaction");
        Scanner scanner=new Scanner(System.in);
        String username=scanner.next();
            for (Transaction each:transactions) {
               if((each.getToWhom()).equals(username)){
                   System.out.println(each);
               }
        }
}
    }
