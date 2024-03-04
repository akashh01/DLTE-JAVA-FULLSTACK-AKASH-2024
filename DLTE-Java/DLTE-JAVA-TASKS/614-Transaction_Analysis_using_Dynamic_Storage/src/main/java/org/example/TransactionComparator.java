package org.example;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transactions> {
    private String byAttribute;
    private String orderBy;

    public TransactionComparator(String userOrder) {
        String[] atThis = userOrder.split(":");// username:ascending
        byAttribute = atThis[0];
        orderBy = atThis[1];
    }

    @Override
    public int compare(Transactions o1, Transactions o2) {
        int returnedOrder = 0;
        switch (byAttribute) {
            case "remark":
            case "REMARK":
            case "Remark":
                returnedOrder = o1.getRemarks().compareTo(o2.getRemarks());
                break;
            case "amount":
            case "AMOUNT":
            case "Amount":
                returnedOrder = o1.getAmountInTransaction().compareTo(o2.getAmountInTransaction());
                break;
            case "date":
            case "DATE":
            case "Date":
                returnedOrder = o1.getDateOfTransaction().compareTo(o2.getDateOfTransaction());
                break;
        }
        return orderBy.equals("ascending") ? returnedOrder : -returnedOrder;
    }
}
