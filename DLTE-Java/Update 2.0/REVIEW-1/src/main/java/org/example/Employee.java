package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {
    private String firstName;
    private String middeName;
    private String lastName;
    private Long employeePhone;
    private Integer employeeId;
    private String email;

    //constructors

    public Employee(){}

    public Employee(String firstName, String middeName, String lastName, Long employeePhone, Integer employeeId, String email) {
        this.firstName = firstName;
        this.middeName = middeName;
        this.lastName = lastName;
        this.employeePhone = employeePhone;
        this.employeeId = employeeId;
        this.email = email;
    }

//getters and setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddeName() {
        return middeName;
    }

    public void setMiddeName(String middeName) {
        this.middeName = middeName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(Long employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return
                "First Name='" + firstName + '\'' +
                ",Midde Name='" + middeName + '\'' +
                ",LastName='" + lastName + '\'' +
                ", Employee Phone=" + employeePhone +
                ", Employee Id=" + employeeId +
                ", email='" + email + '\'' ;
    }
}




