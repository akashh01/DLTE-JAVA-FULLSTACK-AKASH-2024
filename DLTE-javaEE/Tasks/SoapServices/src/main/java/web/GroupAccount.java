package web;

import application.db.Entities.Customer;

import java.util.List;

public class GroupAccount {
    private List<Customer> customerList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public GroupAccount() {
    }

    @Override
    public String toString() {
        return "GroupAccount{" +
                "customerList=" + customerList +
                '}';
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public GroupAccount(List<Customer> customerList) {
        this.customerList = customerList;
    }
}