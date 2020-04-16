package com.example.spring.cloud.streams.emailservice.consumer;

import java.util.Date;

import com.example.spring.cloud.streams.transportdto.Notification;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding(EmailSource.class)
@Slf4j
public class Consumer {
	@StreamListener(target = EmailSource.EMAIL, condition = "headers['notificationPriority']=='low'")
	public void handleLowPriorityEmail(@Payload Notification notification) {
		log.info("LOW PRIORITY NOTIFICATION: Recieved notification message: [{}]: {}", new Date(), notification.toString());
	}

	@StreamListener(target = EmailSource.EMAIL, condition = "headers['notificationPriority']=='high'")
	public void handleHighPriorityEmail(@Payload Notification notification) {
		log.info("HIGH PRIORITY NOTIFICATION: Recieved notification message: [{}]: {}", new Date(), notification.toString());
	}

}
