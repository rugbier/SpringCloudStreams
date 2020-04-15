package com.example.spring.cloud.streams.clientservice.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({EmailSource.class, OrderSource.class})
@Data
@AllArgsConstructor
public class MessageProducer {
	private EmailSource emailSource;
	private OrderSource orderSource;

}
