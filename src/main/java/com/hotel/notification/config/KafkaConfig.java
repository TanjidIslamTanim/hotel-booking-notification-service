package com.hotel.notification.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    public static final String BOOKING_TOPIC = "booking-events";

}