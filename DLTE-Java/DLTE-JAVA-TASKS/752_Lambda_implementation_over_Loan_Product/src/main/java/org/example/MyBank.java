package org.example;

import java.util.ArrayList;
import java.util.Date;

public interface MyBank {
        ArrayList<Loan> loan=new ArrayList<>(20);
        void filterDate(Date startDate,Date endDate);
}
