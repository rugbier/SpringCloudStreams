package com.example.spring.cloud.streams.clientservice.service;

import com.example.spring.cloud.streams.clientservice.producer.MessageProducer;
import com.example.spring.cloud.streams.transportdto.Client;
import com.example.spring.cloud.streams.transportdto.Notification;
import com.example.spring.cloud.streams.transportdto.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ClientService {
    private MessageProducer messageProducer;

    public Client createClient(Client client){
        saveClient(client);
        publishEmailNotification(createEmailNotification(client));
        publishOrder(client.getOrder());
        log.info("Processed client sucessfully : [{}]: {}", new Date(), client.toString());
        return client;
    }

    private Notification createEmailNotification(Client client){
        return Notification.builder()
                .id(UUID.randomUUID())
                .email(client.getEmail())
                .name(client.getName())
                .subject("New registration")
                .message("You have registred as a client into our service.").build();
    }

    private void saveClient(Client client){
        log.info("Saving client into DB");
    }

    private void publishOrder(Order order){
        log.info("Publish Order " + order.getId() +" into stream");
        messageProducer.getOrderSource()
                .orderChannel()
                .send(MessageBuilder.withPayload(order)
                        .setHeader("type", "order")
                        .build());
    }

    private void publishEmailNotification(Notification notification){
        log.info("Publish Notification " + notification.getId() +" into stream");
        messageProducer.getEmailSource()
                .emailChannel()
                .send(MessageBuilder.withPayload(notification)
                        .setHeader("type", "email")
                        .build());
    }
}
