package com.twuc.shopping.api;

import com.twuc.shopping.bo.Order;
import com.twuc.shopping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class OrderController {
    @Autowired
    ShopService shopService;

    @PostMapping("/order")
    public ResponseEntity addOrder (@RequestBody Order order) {
        shopService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/order")
    public ResponseEntity getALLOrder () {
        List<Order> orders = shopService.getAllOrder();
        return ResponseEntity.ok(orders);
    }
}
