package com.example.spring.cloud.orderservice.consumer;

import java.util.Date;

import com.example.spring.cloud.orderservice.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(OrderSource.class)
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@StreamListener(target = OrderSource.ORDER, condition = "headers['type']=='order'")
	public void handle(@Payload Order order) {
		logger.info("recieved a order message : [{}]: {}", new Date(), order.toString());
	}

}
