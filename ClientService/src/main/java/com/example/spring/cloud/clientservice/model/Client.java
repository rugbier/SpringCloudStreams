package com.example.spring.cloud.clientservice.model;

import lombok.*;
import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Client {
	private long id;
	private String name;
	private String surname;
	private String email;
	private String address;
	private Date birth;
	private Date creationDate;
	private Order order;
}
