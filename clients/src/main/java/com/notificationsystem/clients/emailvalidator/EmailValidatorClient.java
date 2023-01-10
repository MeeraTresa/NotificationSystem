package com.notificationsystem.clients.emailvalidator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("emailvalidator")
public interface EmailValidatorClient {
    @GetMapping(path="api/v1/email-validator/{email}")
    EmailValidationResponse isValidEmail(@PathVariable("email") String email);
}
