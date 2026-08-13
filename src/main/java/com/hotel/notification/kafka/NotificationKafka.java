package com.hotel.notification.kafka;

import com.hotel.notification.config.KafkaConfig;
import com.hotel.notification.entity.Notification;
import com.hotel.notification.event.BookingEvent;
import com.hotel.notification.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationKafka {

    private final NotificationService notificationService;

    public NotificationKafka(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(
            topics = KafkaConfig.BOOKING_TOPIC,
            groupId = "notification-group"
    )
    public void consume(BookingEvent event) {

        Notification notification = new Notification();

        notification.setBookingId(event.getBookingId());
        notification.setCustomerName(event.getCustomerName());
        notification.setCustomerEmail(event.getCustomerEmail());

        notification.setNotificationType("EMAIL");

        notification.setStatus("SENT");

        notification.setCreatedAt(LocalDateTime.now());

        //Updated for cancel booking (row 40 - 71)
        if("BOOKING_CANCELLED".equals(event.getEventType()))
        {
            notification.setNotificationType("BOOKING_CANCELLED");

            notification.setMessage(
                    "Booking Cancelled!\n" +
                    "Customer: " + event.getCustomerName() + "\n" +
                    "Email: " + event.getCustomerEmail() + "\n" +
                    "Room: " + event.getRoomNumber() + "\n" +
                    "Check In: " + event.getCheckInDate() + "\n" +
                    "Check Out: " + event.getCheckOutDate()
            );
        }

        else 
        {
            notification.setNotificationType("BOOKING_CONFIRMED");
            
            notification.setMessage(
                "Booking Confirmed!\n" +
                        "Customer: " + event.getCustomerName() + "\n" +
                        "Email: " + event.getCustomerEmail() + "\n" +
                        "Room: " + event.getRoomNumber() + "\n" +
                        "Check In: " + event.getCheckInDate() + "\n" +
                        "Check Out: " + event.getCheckOutDate()
            );

        }

        notificationService.saveNotification(notification);

        System.out.println("Booking received: " + event);  
        
        
    }
}