package org.example.Entities;

import java.io.Serializable;

public class UserInformation implements Serializable {
    private String username;
    private String password;
    private String address;
    private String email;
    private Long contact;
    private Long initialBalace;

    @Override
    public String toString() {
        return "UserInformation{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", initialBalace=" + initialBalace +
                '}';
    }

    public UserInformation() {
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Long getInitialBalace() {
        return initialBalace;
    }

    public void setInitialBalace(Long initialBalace) {
        this.initialBalace = initialBalace;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInformation(String username, String password, String address, String email, Long contact, Long initialBalace) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.initialBalace = initialBalace;
    }

    public UserInformation(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
