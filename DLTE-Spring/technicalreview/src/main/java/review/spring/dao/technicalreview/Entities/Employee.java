package review.spring.dao.technicalreview.Entities;

public class Employee {
    private String firstName;
    private String middeName;
    private String lastName;
    private Long employeePhone;
    private Integer employeeId;
    private String email;
    private Address permenantAddress;
    private Address temporaryAddress;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getPermenantAddress() {
        return permenantAddress;
    }

    public void setPermenantAddress(Address permenantAddress) {
        this.permenantAddress = permenantAddress;
    }

    public Address getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(Address temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public Employee(String firstName, String middeName, String lastName, Long employeePhone, Integer employeeId, String email, Address permenantAddress, Address temporaryAddress) {
        this.firstName = firstName;
        this.middeName = middeName;
        this.lastName = lastName;
        this.employeePhone = employeePhone;
        this.employeeId = employeeId;
        this.email = email;
        this.permenantAddress = permenantAddress;
        this.temporaryAddress = temporaryAddress;
    }
}
