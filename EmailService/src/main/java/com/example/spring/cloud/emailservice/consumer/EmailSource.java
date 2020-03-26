package com.example.spring.cloud.emailservice.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EmailSource {
    String EMAIL = "email";

    @Input(EMAIL)
    SubscribableChannel email();

}
