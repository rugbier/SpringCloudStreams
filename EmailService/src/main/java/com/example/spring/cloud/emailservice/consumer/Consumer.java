package com.example.spring.cloud.emailservice.consumer;

import java.util.Date;

import com.example.spring.cloud.emailservice.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(EmailSource.class)
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@StreamListener(target = EmailSource.EMAIL, condition = "headers['type']=='email'")
	public void handle(@Payload Client client) {
		logger.info("recieved a client message : [{}]: {}", new Date(), client.toString());
	}

}
