package com.example.spring.cloud.streams.orderservice.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({NotificationSource.class})
@Data
@AllArgsConstructor
public class MessageProducer {
    private NotificationSource notificationSource;
}
