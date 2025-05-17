package com.notification.notificationservice.service;

import com.notification.notificationservice.config.RabbitMQConfig;
import com.notification.notificationservice.dto.NotificationRequest;
import com.notification.notificationservice.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    // Use QUEUE_NAME from your config class
  public static final String QUEUE_NAME = "notificationQueue";

    private final List<Notification> notifications = new ArrayList<>();

    // Constructor injection of RabbitTemplate
    public NotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void saveNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getUserNotifications(Long userId) {
        return notifications.stream()
                .filter(n -> n.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public void sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .message(request.getMessage())
                .delivered(true)
                .timestamp(LocalDateTime.now())
                .build();

        // Send notification to RabbitMQ queue

        rabbitTemplate.convertAndSend(QUEUE_NAME, notification);
        System.out.println("Sent message: " + request);
        // Optionally save notification in-memory (depends on your design)
        saveNotification(notification);
    }
}
//@Service
//public class NotificationService {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    public NotificationService(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void sendNotification(String message) {
//        // send to the queue declared above
//        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
//      System.out.println("Sent message: " + message);
//    }
//
//    public List<Notification> getUserNotifications(Long id) {
//        return new ArrayList<>();  // return empty list for now
//
//    }
//}
