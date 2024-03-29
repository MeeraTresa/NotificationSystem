package com.notificationsystem.notification;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Integer id;
    private Integer customerId;
    private String customerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;

    public Notification(Integer customerId, String customerEmail,String sender, String message, LocalDateTime createdAt) {
        this.customerId = customerId;
        this.sender = sender;
        this.customerEmail = customerEmail;
        this.message = message;
        this.sentAt = createdAt;

    }
}
