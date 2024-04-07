package com.fileRouge.customer.controller;

import java.util.Optional;
import javax.validation.Valid;
import com.fileRouge.customer.dto.AuthRequestDto;
import com.fileRouge.customer.dto.AuthResponseDto;
import com.fileRouge.customer.dto.CustomerRequestDto;
import com.fileRouge.customer.dto.CustomerResponseDto;
import com.fileRouge.customer.message.ResponseMessage;
import com.fileRouge.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping("/customer/register")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseMessage customerRegister(@Valid @RequestBody CustomerRequestDto customerRequest) {
    return customerService.customerRegister(customerRequest);
  }

  @PostMapping("/customer/auth")
  @ResponseStatus(HttpStatus.OK)
  public AuthResponseDto authenticateCustomer(@Valid @RequestBody AuthRequestDto authRequest) {
    return customerService.authenticateCustomer(authRequest);
  }

  @GetMapping("/customer")
  @ResponseStatus(HttpStatus.OK)
  public CustomerResponseDto getCustomerDetail(@RequestParam Optional<String> number,
      @RequestParam Optional<String> email) {
    if (!number.isEmpty()) {
      return customerService.getCustomerByNumber(number.get());
    } else if (!email.isEmpty()) {
      return customerService.getCustomerByEmail(email.get());
    }
    return null;
  }
}
