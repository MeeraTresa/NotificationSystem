package com.notificationsystem.service;

import com.notificationsystem.model.Customer;
import com.notificationsystem.repository.CustomerRepository;
import com.notificationsystem.util.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder().firstName(customerRegistrationRequest.firstName()).
                            lastName(customerRegistrationRequest.lastName()).
                            email(customerRegistrationRequest.email()).build();
        //todo : check if email is valid
        //todo : check if email is not taken
        //todo : store customer in db
        customerRepository.save(customer);

    }
}
