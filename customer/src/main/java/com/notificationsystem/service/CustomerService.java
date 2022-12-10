package com.notificationsystem.service;

import com.notificationsystem.model.Customer;
import com.notificationsystem.util.CustomerRegistrationRequest;

public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder().firstName(customerRegistrationRequest.firstName()).
                            lastName(customerRegistrationRequest.lastName()).
                            email(customerRegistrationRequest.email()).build();
        //todo : check if email is valid
        //todo : check if email is not taken
        //todo : store customer in db


    }
}