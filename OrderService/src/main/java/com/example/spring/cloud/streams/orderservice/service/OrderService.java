package com.example.spring.cloud.streams.orderservice.service;

import com.example.spring.cloud.streams.orderservice.producer.MessageProducer;
import com.example.spring.cloud.streams.transportdto.Notification;
import com.example.spring.cloud.streams.transportdto.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {
    MessageProducer messageProducer;

    public Order createOrder(Order order){
        log.info("Starting processing order: " + order.getId());
        saveOrder(order);
        publishNotification(createNotification(order));
        log.info("Order processed sucessfully: [{}]: {}", new Date(), order.toString());
        return order;
    }

    private Notification createNotification(Order order){
        return Notification.builder()
                .id(UUID.randomUUID())
                .email("an@email.com")
                .name("Jhon Doe")
                .subject("New order Purchase")
                .message("You have made a order purchase with order id: " + order.getId()).build();
    }

    private void saveOrder(Order order){
        log.info("Saving order into DB");
    }

    private void publishNotification(Notification notification){
        log.info("Publish order notification " + notification.getId());
        messageProducer.getNotificationSource()
                .emailChannel()
                .send(MessageBuilder.withPayload(notification)
                        .setHeader("notificationPriority", "high")
                        .build());
    }
}
