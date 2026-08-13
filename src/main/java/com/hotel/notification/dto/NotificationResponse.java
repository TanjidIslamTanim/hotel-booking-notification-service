package com.hotel.notification.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {

    private Long id;
    private Long bookingId;
    private String customerName;
    private String customerEmail;
    private String notificationType;
    private String message;
    private String status;
    private LocalDateTime createdAt;

}