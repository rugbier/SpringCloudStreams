package com.example.spring.cloud.orderservice.model;

import lombok.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private int id;
    private String name;
    private double price;
    private double taxes;
    private int quantity;
}
