package com.example.spring.cloud.streams.transportdto;

import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private Date birth;
    private Order order;
}
