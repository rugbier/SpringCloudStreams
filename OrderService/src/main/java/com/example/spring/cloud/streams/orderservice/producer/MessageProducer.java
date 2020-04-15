package com.example.spring.cloud.streams.orderservice.producer;

import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({NotificationSource.class})
@Data
public class MessageProducer {

    private NotificationSource notificationSource;

    public MessageProducer(NotificationSource emailSource) {
        super();
        this.notificationSource = emailSource;
    }

}
