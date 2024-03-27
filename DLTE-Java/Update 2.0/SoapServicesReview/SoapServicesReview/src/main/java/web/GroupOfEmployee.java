package web;

import employee.implement.entites.Employee;

import java.util.ArrayList;
import java.util.List;

public class GroupOfEmployee {
    public List<Employee> employeeList;

    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList=employeeList;
    }

    public GroupOfEmployee(){}
    public GroupOfEmployee(List<Employee> employeeList){
        this.employeeList=employeeList;
    }

    @Override
    public String toString() {
        return "GroupOfEmployee{" +
                "employeeList=" + employeeList +
                '}';
    }
}
