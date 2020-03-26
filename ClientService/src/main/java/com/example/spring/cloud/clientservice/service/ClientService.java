package com.example.spring.cloud.clientservice.service;

import com.example.spring.cloud.clientservice.Utils;
import com.example.spring.cloud.clientservice.model.Client;
import com.example.spring.cloud.clientservice.model.Order;
import com.example.spring.cloud.clientservice.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClientService {
    private Producer producer;

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    public ClientService(Producer producer) {
        super();
        this.producer = producer;
    }


    public Client createClient(Client client){
        client.setCreationDate(Utils.getDate(System.currentTimeMillis()));
        saveClient(client);
        publishEmail(client);
        publishOrder(client.getOrder());
        logger.info("recieved a client message : [{}]: {}", new Date(), client.toString());
        return client;
    }

    private void saveClient(Client client){
        logger.info("Saving client into DB");
    }

    private void publishOrder(Order order){
            producer.getOrderSource()
                    .order()
                    .send(MessageBuilder.withPayload(order)
                            .setHeader("type", "order")
                            .build());
    }

    private void publishEmail(Client client){
        producer.getEmailSource()
                .email()
                .send(MessageBuilder.withPayload(client)
                        .setHeader("type", "email")
                        .build());
    }
}
