package com.hotel.notification.service;

import com.hotel.notification.entity.Notification;
import com.hotel.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    // Save a notification
    public Notification saveNotification(Notification notification) {
        return repository.save(notification);
    }

    // Get all notifications
    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    // Get notification by ID
    public Notification getNotificationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete notification
    public void deleteNotification(Long id) {
        repository.deleteById(id);
    }
}