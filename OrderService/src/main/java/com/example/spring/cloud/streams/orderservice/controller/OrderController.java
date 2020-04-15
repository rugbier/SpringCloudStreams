package com.example.spring.cloud.streams.orderservice.controller;

import com.example.spring.cloud.streams.orderservice.service.OrderService;
import com.example.spring.cloud.streams.transportdto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order")
    public Order createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return order;
    }
}
