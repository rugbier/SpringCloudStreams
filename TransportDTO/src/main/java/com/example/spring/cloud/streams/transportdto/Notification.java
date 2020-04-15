package com.example.spring.cloud.streams.transportdto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    private UUID id;
    private String name;
    private String email;
    private String subject;
    private String message;
}