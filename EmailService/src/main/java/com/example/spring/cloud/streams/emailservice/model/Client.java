package com.example.spring.cloud.streams.emailservice.model;

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
