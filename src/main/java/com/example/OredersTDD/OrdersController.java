package com.example.OredersTDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    //查询所有订单
    @GetMapping
    public HttpEntity<List<Orders>> getAllOrders() {
        return new ResponseEntity<>(ordersService.getAllOrders(), HttpStatus.OK);
    }
}
