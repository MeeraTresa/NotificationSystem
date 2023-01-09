package com.notificationsystem.emailvalidator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailValidationHistoryRepository extends JpaRepository<EmailValidationHistory, Integer> {
}
