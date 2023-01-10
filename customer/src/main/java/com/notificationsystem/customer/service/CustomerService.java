package com.notificationsystem.customer.service;

import com.notificationsystem.clients.emailvalidator.EmailValidationResponse;
import com.notificationsystem.clients.emailvalidator.EmailValidatorClient;
import com.notificationsystem.customer.util.CustomerRegistrationRequest;
import com.notificationsystem.customer.model.Customer;
import com.notificationsystem.customer.repository.CustomerRepository;
import com.notificationsystem.clients.notification.NotificationClient;
import com.notificationsystem.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final EmailValidatorClient emailValidatorClient;
    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder().firstName(customerRegistrationRequest.firstName()).
                            lastName(customerRegistrationRequest.lastName()).
                            email(customerRegistrationRequest.email()).build();
        //todo : check if email is valid
        /*
        Deleted since now we are using OpenFeign clients to get the EmailValidationResponse
        from com.notificationsystem.clients.emailvalidator
        private final RestTemplate restTemplate;
        EmailValidationResponse emailValidationResponse = restTemplate.getForObject(
                "http://EMAILVALIDATOR/api/v1/email-validator/{email}",
                EmailValidationResponse.class,
                customerRegistrationRequest.email());
         */
        EmailValidationResponse emailValidationResponse = emailValidatorClient.isValidEmail(customerRegistrationRequest.email());
        if(!emailValidationResponse.isValidEmail()){
            throw new IllegalStateException("Invalid Email");
        }
        //todo : check if email is not taken

        customerRepository.saveAndFlush(customer);
        //todo : use a Message Queue to make it async
        notificationClient.sendNotification(new NotificationRequest(customer.getId(),customer.getEmail(),
                           String.format("Hi %s, You have successfully registered in the RSS Feed Notification System",
                                            customer.getFirstName())));
    }
}
