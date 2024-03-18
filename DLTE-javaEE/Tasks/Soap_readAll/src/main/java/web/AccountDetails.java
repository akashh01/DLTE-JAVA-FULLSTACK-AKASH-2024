package web;

import application.db.Entities.Customer;

import java.util.List;

public class  AccountDetails{
    private Customer customers;

    public AccountDetails(Customer customers) {
        this.customers = customers;
    }

    public AccountDetails() {
    }

    public Customer getDetails() {
        return customers;
    }

    public void setDetails(Customer customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Acocount detail{" +
                "account=" + customers +
                '}';
    }
}