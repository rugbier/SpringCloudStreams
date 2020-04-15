package com.example.spring.cloud.streams.orderservice.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NotificationSource {
    String EMAIL = "email";

    @Output(EMAIL)
    MessageChannel emailChannel();
}
