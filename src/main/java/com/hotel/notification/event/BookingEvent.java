package com.hotel.notification.event;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEvent {

    private Long bookingId;
    private String customerName;
    private String customerEmail;
    private String roomNumber;
    private String checkInDate;
    private String checkOutDate;
    private String eventType; //updated

}