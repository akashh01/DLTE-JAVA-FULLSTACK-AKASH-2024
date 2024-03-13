package org.example.remotes;

import org.example.Employee;
import org.example.Address;

public interface CollectCheckData {

    //abstract to collect personal data
    public abstract Employee collectPersonalData(Employee employee);
    //abstract to display those data
    public abstract void displayData();
    //to collect address
    public abstract Address collectAddress();
    //validate email address




}
