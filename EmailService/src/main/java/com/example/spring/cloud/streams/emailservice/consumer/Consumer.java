package com.example.spring.cloud.streams.emailservice.consumer;

import java.util.Date;

import com.example.spring.cloud.streams.transportdto.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding(EmailSource.class)
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@StreamListener(target = EmailSource.EMAIL, condition = "headers['type']=='email'")
	public void handle(@Payload Notification notification) {
		logger.info("Recieved notification message: [{}]: {}", new Date(), notification.toString());
	}

}
