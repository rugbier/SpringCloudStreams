package com.example.spring.cloud.streams.transportdto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private int id;
    private String name;
    private double price;
    private double taxes;
    private int quantity;
}

