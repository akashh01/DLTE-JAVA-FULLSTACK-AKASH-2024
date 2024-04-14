//package loan.dao.project.loan.entities;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import java.util.Collection;
//
//public class Customer implements UserDetails {
//    private Integer customerId;
//    private String customerName;
//    private String customerAddress;
//    private String customerStatus;
//    private Long customerContact;
//    private String username;
//    private String password;
//    private int attempts;
//
//    public Customer(Integer customerId, String customerName, String customerAddress, String customerStatus, Long customerContact, String username, String password) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.customerStatus = customerStatus;
//        this.customerContact = customerContact;
//        this.username = username;
//        this.password = password;
//    }
//
//    public Customer(Integer customerId, String customerName, String customerAddress, String customerStatus, Long customerContact, String username, String password, int attempts) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.customerStatus = customerStatus;
//        this.customerContact = customerContact;
//        this.username = username;
//        this.password = password;
//        this.attempts = attempts;
//    }
//
//    public Customer() {
//    }
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public String getCustomerStatus() {
//        return customerStatus;
//    }
//
//    public void setCustomerStatus(String customerStatus) {
//        this.customerStatus = customerStatus;
//    }
//
//    public Long getCustomerContact() {
//        return customerContact;
//    }
//
//    public void setCustomerContact(Long customerContact) {
//        this.customerContact = customerContact;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getAttempts() {
//        return attempts;
//    }
//
//    public void setAttempts(int attempts) {
//        this.attempts = attempts;
//    }
//    public int getMaxAttempt() {
//        return maxAttempt;
//    }
//    //    private int status;
//    private final int maxAttempt=3;
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId=" + customerId +
//                ", customerName='" + customerName + '\'' +
//                ", customerAddress='" + customerAddress + '\'' +
//                ", customerStatus='" + customerStatus + '\'' +
//                ", customerContact=" + customerContact +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", attempts=" + attempts +
//                '}';
//    }
//}
