package spring.task.jpa.jpatask.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Account {
        @Id
        private String username;
        private String password;
        private String address;
        private String email;
        private Long contact;
        private Long initial_Balance;

     public String getUsername() {
        return username;
    }

    public Account() {
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
        return initial_Balance;
    }

    public void setInitialBalace(Long initialBalace) {
        this.initial_Balance = initialBalace;
    }

    public Account(String username, String password, String address, String email, Long contact, Long initialBalance) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.initial_Balance = initialBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact=" + contact +
                ", initial_Balance=" + initial_Balance +
                '}';
    }
}
