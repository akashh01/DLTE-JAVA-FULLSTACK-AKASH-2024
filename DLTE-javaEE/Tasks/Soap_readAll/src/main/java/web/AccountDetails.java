package web;

import application.db.Entities.Customer;

import java.util.List;

public class  AccountDetails{
    private List<Customer> customers;

    public AccountDetails(List<Customer> customers) {
        this.customers = customers;
    }

    public AccountDetails() {
    }

    public List<Customer> getDetails() {
        return customers;
    }

    public void setDetails(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Acocount detail{" +
                "account=" + customers +
                '}';
    }
}