package org.example;

public class Employee {
    private String firstName;
    private String middeName;
    private String lastName;
    private Long employeePhone;
    private Integer employeeId;
    private String email;

    //constructors
    public Employee(){}

    public Employee(String firstName, String middeName, String lastName, Long employeePhone, Integer employeeId, String houseName, String streetName, String cityName, String stateName, Integer pincode, String email) {
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

}
class Address{
    private String houseName;
    private String streetName;
    private String cityName;
    private String stateName;
    private Integer pincode;
    public void address(){}

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
}

