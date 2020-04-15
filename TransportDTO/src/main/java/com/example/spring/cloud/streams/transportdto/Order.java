package com.example.spring.cloud.streams.transportdto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private double id;
    private Date orderDate;
    private double total;
    private double totalTaxes;
    private List<Item> items;
}
