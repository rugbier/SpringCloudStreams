package com.example.spring.cloud.emailservice;

import lombok.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
	private long id;
	private String name;
	private String surname;
	private String email;
	private String address;
	private Date birth;
	private Date creationDate;
}
