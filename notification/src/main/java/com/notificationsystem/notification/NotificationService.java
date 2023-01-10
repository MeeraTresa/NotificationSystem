package com.notificationsystem.notification;

import com.notificationsystem.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(new Notification(notificationRequest.customerId(), notificationRequest.customerEmail(),
                                        "RSSNotificationSystem", notificationRequest.message(), LocalDateTime.now()
                                        ));
    }

}
