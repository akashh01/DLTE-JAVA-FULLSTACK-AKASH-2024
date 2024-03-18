package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Marshelling {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        // insurance=new Insurance("Max Life",3,1200,200000);
        List<Transaction> transactions= Stream.of(
                new Transaction(new Date("12/12/2002"),500,"Ajay","Friend"),
                new Transaction(new Date("12/12/2002"),5000,"Deepansh","Family"),
                new Transaction(new Date("12/12/2002"),6500,"Akash","Education"),
                new Transaction(new Date("12/12/2002"),7000,"Current","Bills"),
                new Transaction(new Date("12/12/2002"),50000,"Ajay","Friend")
                ).collect(Collectors.toList());
        JAXBContext context=JAXBContext.newInstance(AllTransactions.class);
        AllTransactions details=new AllTransactions(transactions);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(details,new FileOutputStream("Transaction.xml"));
        System.out.println("XML has built");
    }
    }

