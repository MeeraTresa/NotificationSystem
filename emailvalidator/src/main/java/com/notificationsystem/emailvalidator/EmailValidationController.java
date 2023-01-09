package com.notificationsystem.emailvalidator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/email-validator")
@AllArgsConstructor
@Slf4j
public class EmailValidationController {
    private final EmailValidationService emailValidationService;

    @GetMapping(path="{email}")
    public EmailValidationResponse isValidEmail(@PathVariable("email") String email){
        log.info("Email Validation for email {}",email);
        boolean isValidEMail = emailValidationService.isValidEmailId(email);
        return new EmailValidationResponse(isValidEMail);
    }
}
