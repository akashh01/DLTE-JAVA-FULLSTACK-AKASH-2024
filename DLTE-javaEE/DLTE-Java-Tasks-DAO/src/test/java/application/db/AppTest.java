package application.db;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import application.db.Entities.Customer;
import application.db.Exception.UserNotFoundException;
import application.db.Remotes.StorageTarget;
import application.db.Remotes.UserInfoRepository;
import application.db.Services.UserInfoServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{
    @Mock
    private StorageTarget mockStorageTarget;
    @Mock
    private UserInfoRepository userInfoRepository;
    private UserInfoServices services;
    @Before
    public void prepareStore(){
        when(mockStorageTarget.getUserInfoRepository()).thenReturn(userInfoRepository);
        services=new UserInfoServices(mockStorageTarget);
    }

    @Test
    public void testCallAddInformation() {
        // Given
        Customer customer = new Customer("Prashanth", "prashanth123", "Mangalore", "prashanth@gmail", 987455335L, 1000L, null);

        // When
        doNothing().when(userInfoRepository).addInformation(customer);
        services.callAddInformation(customer);

        // Then
        verify(userInfoRepository).addInformation(customer);
    }

    @Test
    public void testCallPasswordValidate_ValidPassword() {
        // Given
        String username = "Prashanth";
        String password = "prashanth123";

        Customer customer = new Customer("Prashanth", "prashanth123", "Mangalore", "prashanth@gmail", 987455335L, 1000L, null);
        // When
        when(userInfoRepository.passwordValidate(username, password)).thenReturn(true);
        boolean result = services.callPasswordValidate(customer.getUsername(), customer.getPassword());

        // Then
        assertTrue(result);
    }

    @Test
    public void testCallPasswordValidate_InvalidPassword() {
        // Given
        String username = "Prashanth";
        String password = "prashanth123";

        Customer customer = new Customer("Prashanth", "prashanth123", "Mangalore", "prashanth@gmail", 987455335L, 1000L, null);
        // When
        when(userInfoRepository.passwordValidate(username, password)).thenReturn(false);
        boolean result = services.callPasswordValidate(customer.getUsername(), customer.getPassword());

        // Then
        assertFalse(result);
    }

    @Test
    public void testCallDepositAmountInto_UserFound() {
        // Given
        String username = "prash02";
        Long amount = 1000L;

        Customer customer = new Customer("Prashanth", "prashanth123", "Mangalore", "prashanth@gmail", 987455335L, 1000L, null);
        // When
        doNothing().when(userInfoRepository).DepositAmountInto(username, amount);
        services.callDepositAmountInto(username, amount);

        // Then
        verify(userInfoRepository).DepositAmountInto(username, amount);
    }


}
