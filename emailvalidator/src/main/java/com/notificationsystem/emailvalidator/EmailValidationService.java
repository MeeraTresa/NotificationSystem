package com.notificationsystem.emailvalidator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmailValidationService {
    private final EmailValidationHistoryRepository emailValidationHistoryRepository;
    public boolean isValidEmailId(String email){
        emailValidationHistoryRepository.save(new EmailValidationHistory(email,true, LocalDateTime.now()));
        return true;
    }
}
