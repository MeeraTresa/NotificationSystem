package com.notificationsystem.customer.service;

import com.notificationsystem.customer.util.CustomerRegistrationRequest;
import com.notificationsystem.customer.model.Customer;
import com.notificationsystem.customer.repository.CustomerRepository;
import com.notificationsystem.customer.util.EmailValidationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder().firstName(customerRegistrationRequest.firstName()).
                            lastName(customerRegistrationRequest.lastName()).
                            email(customerRegistrationRequest.email()).build();
        //todo : check if email is valid

        EmailValidationResponse emailValidationResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/email-validator/{email}",
                EmailValidationResponse.class,
                customerRegistrationRequest.email());
        if(!emailValidationResponse.isValidEmail()){
            throw new IllegalStateException("Invalid Email");
        }
        //todo : check if email is not taken
        //todo : store customer in db

        customerRepository.save(customer);
        //todo: send notification
    }
}
