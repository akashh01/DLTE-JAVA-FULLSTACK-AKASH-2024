package web;

import application.db.Entities.Customer;

import java.util.List;

public class  AccountDetails{
    private Customer customers;
    private List<Customer> customerList;
    public AccountDetails(List<Customer> customerList) {
        this.customerList=customerList;
    }

    public AccountDetails() {
    }

    public List<Customer> getDetails() {
        return customerList;
    }

    public void setDetails(List<Customer> customerList) {
        this.customerList=customerList;
    }

    @Override
    public String toString() {
        return "Acocount detail{" +
                "account=" + customers +
                '}';
    }
}