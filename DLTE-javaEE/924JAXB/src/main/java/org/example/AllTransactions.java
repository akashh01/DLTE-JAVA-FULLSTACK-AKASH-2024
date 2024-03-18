package org.example;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="listOfTransactions")
public class AllTransactions {
   private List<Transaction> allTransaction;

    public AllTransactions(List<Transaction> allTransaction) {
        this.allTransaction = allTransaction;
    }
    @XmlElement("details")
    public List<Transaction> getAllTransaction() {
        return allTransaction;
    }

    public void setAllTransaction(List<Transaction> allTransaction) {
        this.allTransaction = allTransaction;
    }

    public AllTransactions() {
    }
}
