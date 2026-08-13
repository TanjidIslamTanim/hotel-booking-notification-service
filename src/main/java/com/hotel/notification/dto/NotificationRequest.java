package com.hotel.notification.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {

    private Long bookingId;
    private String customerName;
    private String customerEmail;
    private String notificationType;
    private String message;
    private String status;

}