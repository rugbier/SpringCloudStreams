package com.example.spring.cloud.clientservice.controller;

import com.example.spring.cloud.clientservice.model.Client;
import com.example.spring.cloud.clientservice.producer.Producer;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
public class ClientController {

	private Producer producer;

	public ClientController(Producer producer) {

		super();
		this.producer = producer;
	}

	private Date getDate(long timeMillis){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(timeMillis);
		return c.getTime();
	}


	@PostMapping(value = "/client")
	public Client createClient(@RequestBody Client client) {

		client.setCreationDate(getDate(System.currentTimeMillis()));
		producer.getMysource()
			.output()
			.send(MessageBuilder.withPayload(client)
				.setHeader("type", "client")
				.build());

		return client;
	}

}
