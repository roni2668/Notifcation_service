package com.notification.notificationservice.queue;

import com.notification.notificationservice.dto.NotificationRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationMessageListener {

    @RabbitListener(queues = "notificationQueue")
    public void receiveMessage(NotificationRequest request) {
        System.out.println("Received notification for User " + request.getUserId()
                + " via " + request.getType() + ": " + request.getMessage());

        // Simulate sending logic here (email, SMS, etc.)
    }
}