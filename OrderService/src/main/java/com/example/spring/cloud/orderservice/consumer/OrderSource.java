package com.example.spring.cloud.orderservice.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderSource {

    String ORDER = "order";

    @Input(ORDER)
    SubscribableChannel order();
}
