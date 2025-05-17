package com.notification.notificationservice.controller;


import com.notification.notificationservice.dto.NotificationRequest;
import com.notification.notificationservice.model.Notification;
import com.notification.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/notifications")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        service.sendNotification(request);
        return ResponseEntity.ok("Notification queued.");
    }

    @GetMapping("/users/{id}/notifications")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserNotifications(id));
    }
}
