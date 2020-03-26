package com.example.spring.cloud.clientservice.controller;

import com.example.spring.cloud.clientservice.model.Client;
import com.example.spring.cloud.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping(value = "/client")
	public Client createClient(@RequestBody Client client) {
		clientService.createClient(client);
		return client;
	}

}
