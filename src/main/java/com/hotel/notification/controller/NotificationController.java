package com.hotel.notification.controller;

import com.hotel.notification.entity.Notification;
import com.hotel.notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    // Create a notification
    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {

        if (notification.getCreatedAt() == null) {
            notification.setCreatedAt(LocalDateTime.now());
        }

        return service.saveNotification(notification);
    }

    // Get all notifications
    @GetMapping
    public List<Notification> getAllNotifications() {
        return service.getAllNotifications();
    }

    // Get notification by ID
    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return service.getNotificationById(id);
    }

    // Delete notification
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        service.deleteNotification(id);
        return "Notification deleted successfully!";
    }
}