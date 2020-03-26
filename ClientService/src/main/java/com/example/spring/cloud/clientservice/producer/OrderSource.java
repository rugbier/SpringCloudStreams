package com.example.spring.cloud.clientservice.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderSource {

    String ORDER = "order";

    @Output(ORDER)
    MessageChannel order();
}
