package com.fileRouge.customer.service;



import com.fileRouge.customer.dto.AuthRequestDto;
import com.fileRouge.customer.dto.AuthResponseDto;
import com.fileRouge.customer.dto.CustomerRequestDto;
import com.fileRouge.customer.dto.CustomerResponseDto;
import com.fileRouge.customer.message.ResponseMessage;
import com.fileRouge.customer.model.CustomerModel;
import com.fileRouge.customer.repository.CustomerRepository;
import com.fileRouge.customer.service.CustomerService;
import com.fileRouge.customer.util.JwtToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void testCustomerRegister() {
        CustomerRequestDto customerRequest = new CustomerRequestDto();
        customerRequest.setFirstName("halima");
        customerRequest.setLastName("el amri");
        customerRequest.setEmail("elamrihalima@gmail.com");
        customerRequest.setPassword("pass1234");

        ResponseMessage response = customerService.customerRegister(customerRequest);

        assertEquals("success", response.getMessage());
        verify(customerRepository, times(1)).insert(any(CustomerModel.class));
    }

    @Test
    public void testAuthenticateCustomer() {
        AuthRequestDto authRequest = new AuthRequestDto();
        authRequest.setEmail("elamrihalima@gmail.com");
        authRequest.setPassword("pass1234");

        CustomerModel customer = new CustomerModel();
        customer.setEmail("elamrihalima@gmail.com");
        customer.setPassword("encodedPassword");

        when(customerRepository.findByEmail("elamrihalima@gmail.com")).thenReturn(Optional.of(customer));
        when(passwordEncoder.matches("pass1234", "encodedPassword")).thenReturn(true);

        AuthResponseDto response = customerService.authenticateCustomer(authRequest);

        assertEquals("elamrihalima@gmail.com", response.getEmail());
        verify(customerRepository, times(1)).findByEmail("elamrihalima@gmail.com");
        verify(passwordEncoder, times(1)).matches("pass1234", "encodedPassword");
    }

    @Test
    public void testGetCustomerByNumber() {
        String customerNumber = "12345678";

        CustomerModel customer = new CustomerModel();
        customer.setCustNumber(customerNumber);

        when(customerRepository.findByCustNumber("12345678")).thenReturn(Optional.of(customer));

        CustomerResponseDto response = customerService.getCustomerByNumber(customerNumber);

        assertEquals("12345678", response.getCustNumber());
        verify(customerRepository, times(1)).findByCustNumber("12345678");
    }

    @Test
    public void testGetCustomerByEmail() {
        String email = "elamrihalima@gmail.com";

        CustomerModel customer = new CustomerModel();
        customer.setEmail(email);

        when(customerRepository.findByEmail("elamrihalima@gmail.com")).thenReturn(Optional.of(customer));

        CustomerResponseDto response = customerService.getCustomerByEmail(email);

        assertEquals("elamrihalima@gmail.com", response.getEmail());
        verify(customerRepository, times(1)).findByEmail("elamrihalima@gmail.com");
    }
}
