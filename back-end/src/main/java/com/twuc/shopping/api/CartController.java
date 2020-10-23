package com.twuc.shopping.api;

import com.twuc.shopping.bo.Cart;
import com.twuc.shopping.bo.Good;
import com.twuc.shopping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class CartController {
    @Autowired
    ShopService shopService;

    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getCart(){
        List<Cart> carts = shopService.getCart();
        return ResponseEntity.ok(carts);

    }

    @PostMapping("/cart")
    public ResponseEntity createAcgOrders(@RequestBody Cart cart) {
        shopService.createCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
