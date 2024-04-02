package org.example.interfaces;

import org.example.entites.Employee;

import java.util.ArrayList;
import java.util.List;

public interface LambdaFilter {
    List<Employee> employeeInterfaceList=new ArrayList<>();
    public void searchByPincode(int pincode);
}
