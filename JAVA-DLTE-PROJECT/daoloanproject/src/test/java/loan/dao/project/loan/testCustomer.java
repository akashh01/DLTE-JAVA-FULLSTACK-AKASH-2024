package loan.dao.project.loan;
import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.exceptions.CustomerSignIn;
import loan.dao.project.loan.services.CustomerAuthServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class testCustomer {
    @InjectMocks
    CustomerAuthServices customerAuthServices;

    @Mock
    JdbcTemplate jdbcTemplate;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("loandao");

    @Test
    void testLoadUserByUsername_UserExists() {
        //mock customer check load by username
        String username = "amal12";
        Customer customer1 = new Customer();
        customer1.setUsername(username);
        customer1.setPassword("pass123");
        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(Collections.singletonList(customer1));
        UserDetails userDetails = customerAuthServices.loadUserByUsername(username);
        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
    }
    @Test
    void testLoadUserByUsername_UserNotExists() {
        //mock the usernamenotfound by loaduser
        String username = "akhil";
        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class)))
                .thenThrow(UsernameNotFoundException.class);
        // When & Then
        assertThrows(UsernameNotFoundException.class, () -> {
            customerAuthServices.loadUserByUsername(username);
        });
    }

    @Test
    void testSigningUp() {
        // Mock customer data
        Customer customer1 = new Customer();
        customer1.setCustomerName("akash");
        customer1.setCustomerAddress("kannur");
        customer1.setCustomerContact(99999999999L);
        customer1.setUsername("akash");
        customer1.setPassword("akas12");
        //using when with any indicating match call when ant argument is passed
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);
        Customer result = customerAuthServices.signingUp(customer1);
         assertEquals("akash", result.getUsername());
        assertEquals("Active", result.getCustomerStatus()); // customer status is set to "Active"
        assertEquals(customer1.getAuthorities(),result.getAuthorities());
        assertEquals(customer1.isAccountNonExpired(),result.isAccountNonExpired());
        assertEquals(customer1.isAccountNonLocked(),result.isAccountNonLocked());
        assertEquals(customer1.isCredentialsNonExpired(),result.isCredentialsNonExpired());
        assertEquals(customer1.isEnabled(),result.isEnabled());
    }

    @Test
    public void testSigningUpFailure() {
        // Mock customer data
        Customer customer1 = new Customer();
        customer1.setCustomerName("akash");
        customer1.setCustomerAddress("kannur");
        customer1.setCustomerContact(99999999999L);
        customer1.setUsername("akash");
        customer1.setPassword("akas12");
        //throwing the exception in signUp
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any(), any())).thenReturn(0);
        assertThrows(CustomerSignIn.class, () -> customerAuthServices.signingUp(customer1));

    }

    @Test
    void testFindByUserName() {
        // Mock customer data
        Customer customer1 = new Customer(123, "Amal", "Kanpur", "Active", 89874565554L, "amaall", "amal123", 0);
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(Collections.singletonList(customer1));
        //mocked customer with username amal and trying to retrive it back
        Customer result = customerAuthServices.findByUserName("amaall");
        assertEquals(customer1, result); // customer object matches the expected one
        verify(jdbcTemplate).query(anyString(), any(RowMapper.class)); // Verify jdbcTemplate method called on mock object

    }

    @Test
    void testFindByUserNameNotFound() {
        // return an empty list of customers
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(Collections.emptyList());
        assertThrows(UsernameNotFoundException.class, () -> customerAuthServices.findByUserName("nonexistentUser"));
    }

    @Test
    void testFilterByUserName() {
        // Mock customer data
        List<Customer> customerList = Arrays.asList(
                new Customer(123, "Amal", "Kanpur", "Active", 89874565554L, "amaall", "amal123", 0),
                new Customer(124, "Anagha", "Mangalore", "Active", 9876543210L, "anaghas", "pass123", 0),
                new Customer(125, "Sinchan", "Bangalore", "Inactive", 1234567890L, "sinchans", "123pass", 0)
        );
        // Call the method to be tested
        Customer result = customerAuthServices.filterByUserName(customerList, "sinchans");
        assertNotNull(result);
        assertEquals(125, result.getCustomerId()); // Ensure the correct customer is returned
        assertEquals("Sinchan", result.getCustomerName()); // Ensure the correct customer is returned
    }

    @Test
    void testFilterByUserNameNotFound() {
        // Mock customer data
        List<Customer> customerList = new ArrayList<>(Arrays.asList(
                new Customer(123, "Amal", "Kanpur", "Active", 89874565554L, "amaall", "amal123", 0),
                new Customer(124, "Anagha", "Mangalore", "Active", 9876543210L, "anaghas", "pass123", 0),
                new Customer(125, "Sinchan", "Bangalore", "Inactive", 1234567890L, "sinchans", "123pass", 0)
        ));

        Customer customer1 = new Customer();
        customer1.setCustomerName("akash");
        customer1.setCustomerAddress("kannur");
        customer1.setCustomerContact(99999999999L);
        customer1.setUsername("akash");
        customer1.setPassword("akas12");
        customer1.setCustomerId(126);
        customer1.setCustomerStatus("Active");
        customer1.setAttempts(0);
        // Add the new customer to the list
        customerList.add(customer1);

        Customer result = customerAuthServices.filterByUserName(customerList, "annapoorna");
        // Assertions
        assertNull(result); // Ensure no customer is found
    }


    @Test
    void testUpdateStatus() {
        Customer customer = new Customer();
        customer.setUsername("amaall");
        //setting custstatus an inactive where username is same, eq for stubbing
        when(jdbcTemplate.update(anyString(), eq("Inactive"), eq("amaall"))).thenReturn(1);
        customerAuthServices.updateStatus(customer);
        verify(jdbcTemplate).update(
                "update MYBANK_APP_CUSTOMER set customer_status=? where username=?",
                "Inactive",
                "amaall" // Adjust username accordingly
        );
    }

    @Test
    public void testUpdateAttempts() {
        Customer customer = new Customer();
        customer.setUsername("Akashh");
        customer.setAttempts(3);
        //try updating gets proper loggers
        customerAuthServices.updateAttempts(customer);
        verify(jdbcTemplate).update("update MYBANK_APP_CUSTOMER set ATTEMPTS=? where USERNAME=?", new Object[]{customer.getAttempts(), customer.getUsername()});
    }


}













