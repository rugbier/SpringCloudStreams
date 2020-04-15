package com.example.spring.cloud.streams.clientservice.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmailSource {
        String EMAIL = "email";

        @Output(EMAIL)
        MessageChannel emailChannel();
}
