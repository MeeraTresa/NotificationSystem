package com.notificationsystem.emailvalidator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmailValidationHistory {
    @Id
    @SequenceGenerator( name = "email_id_sequence", sequenceName = "email_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "email_id_sequence"
    )
    private Integer id;
    private String email;
    private Boolean isValid;
    private LocalDateTime createdAt;

    public EmailValidationHistory(String email, Boolean isValid, LocalDateTime createdAt) {
        this.email = email;
        this.isValid = isValid;
        this.createdAt = createdAt;
    }
}
