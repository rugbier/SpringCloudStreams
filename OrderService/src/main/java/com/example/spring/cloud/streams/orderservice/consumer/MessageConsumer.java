package com.example.spring.cloud.streams.orderservice.consumer;

import java.util.Date;

import com.example.spring.cloud.streams.orderservice.service.OrderService;
import com.example.spring.cloud.streams.transportdto.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(OrderSource.class)
@Slf4j
public class MessageConsumer {

	@Autowired
	private OrderService orderService;

	@StreamListener(target = OrderSource.ORDER, condition = "headers['type']=='order'")
	public void handle(@Payload Order order) {
		log.info("Recieved an order message : [{}]: {}", new Date(), order.toString());
		orderService.createOrder(order);
	}

}
