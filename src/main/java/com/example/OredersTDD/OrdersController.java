package com.example.OredersTDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //创建停车订单
    @PostMapping
    public HttpEntity addOrders(@RequestBody Orders orders) {
        if(ordersService.addOrders(orders)){
            return new ResponseEntity(HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }


    }
}
