package com.example.spring.cloud.streams.orderservice.model;

import lombok.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	private double id;
	private Date orderDate;
	private double total;
	private double totalTaxes;
	private List<Item> items;
}
