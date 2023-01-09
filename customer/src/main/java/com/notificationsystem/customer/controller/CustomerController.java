package com.notificationsystem.customer.controller;

import com.notificationsystem.customer.service.CustomerService;
import com.notificationsystem.customer.util.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    //Records are immutable data classes that require only the type and name of fields.
    //The equals, hashCode, and toString methods, as well as the private, final fields and public constructor
    //are generated by the Java compiler.
    @PostMapping()
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("New customer registration {}",customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}