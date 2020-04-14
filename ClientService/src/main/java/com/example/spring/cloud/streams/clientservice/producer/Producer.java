package com.example.spring.cloud.streams.clientservice.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({EmailSource.class, OrderSource.class})
public class Producer {

	private EmailSource emailSource;
	private OrderSource orderSource;

	public Producer(EmailSource emailSource, OrderSource orderSource) {
		super();
		this.emailSource = emailSource;
		this.orderSource = orderSource;
	}

	public EmailSource getEmailSource() {
		return emailSource;
	}

	public OrderSource getOrderSource() {
		return orderSource;
	}

	public void setMysource(EmailSource emailSource) {
		this.emailSource = emailSource;
	}

	public void setMysource(OrderSource orderSource) {
		this.orderSource = orderSource;
	}

}
