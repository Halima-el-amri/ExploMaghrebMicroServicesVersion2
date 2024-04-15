
package com.fileRouge.customer.service;

import com.fileRouge.customer.dto.AuthRequestDto;
import com.fileRouge.customer.dto.AuthResponseDto;
import com.fileRouge.customer.dto.CustomerRequestDto;
import com.fileRouge.customer.dto.CustomerResponseDto;
import com.fileRouge.customer.message.ResponseMessage;
import com.fileRouge.customer.model.CustomerModel;
import com.fileRouge.customer.repository.CustomerRepository;
import com.fileRouge.customer.util.JwtToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtToken jwtService;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        lenient().when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
    }

    @Test
    public void customerRegisterShouldReturnSuccessWhenEmailIsUnique() {
        CustomerRequestDto customerRequest = new CustomerRequestDto();
        customerRequest.setEmail("uniqueEmail@gmail.com");

        ResponseMessage response = customerService.customerRegister(customerRequest);

        assertEquals("success", response.getMessage());
        verify(customerRepository, times(1)).insert(any(CustomerModel.class));
    }

    @Test
    public void customerRegisterShouldThrowExceptionWhenEmailAlreadyExists() {
        CustomerRequestDto customerRequest = new CustomerRequestDto();
        customerRequest.setEmail("existingEmail@gmail.com");

        when(customerRepository.insert((CustomerModel) any())).thenThrow(DataIntegrityViolationException.class);

        assertThrows(ResponseStatusException.class, () -> customerService.customerRegister(customerRequest));
    }



    @Test
    public void authenticateCustomerShouldThrowExceptionWhenEmailIsInvalid() {
        AuthRequestDto authRequest = new AuthRequestDto();
        authRequest.setEmail("invalidEmail@gmail.com");

        when(customerRepository.findByEmail(any())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> customerService.authenticateCustomer(authRequest));
    }

    @Test
    public void authenticateCustomerShouldThrowExceptionWhenPasswordIsInvalid() {
        AuthRequestDto authRequest = new AuthRequestDto();
        authRequest.setEmail("validEmail@gmail.com");
        authRequest.setPassword("invalidPassword");

        when(customerRepository.findByEmail(any())).thenReturn(Optional.of(new CustomerModel()));
        when(passwordEncoder.matches(any(), any())).thenReturn(false);

        assertThrows(ResponseStatusException.class, () -> customerService.authenticateCustomer(authRequest));
    }



    @Test
    public void getCustomerByNumberShouldThrowExceptionWhenNumberDoesNotExist() {
        when(customerRepository.findByCustNumber(any())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> customerService.getCustomerByNumber("nonExistingNumber"));
    }



    @Test
    public void getCustomerByEmailShouldThrowExceptionWhenEmailDoesNotExist() {
        when(customerRepository.findByEmail(any())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> customerService.getCustomerByEmail("nonExistingEmail@gmail.com"));
    }
}