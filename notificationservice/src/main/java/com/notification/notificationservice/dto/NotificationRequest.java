package com.notification.notificationservice.dto;

import com.notification.notificationservice.enums.NotificationType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private Long userId;
    private NotificationType type;
    private String message;
}