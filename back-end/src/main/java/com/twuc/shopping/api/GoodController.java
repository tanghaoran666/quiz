package com.twuc.shopping.api;


import com.twuc.shopping.bo.Good;
import com.twuc.shopping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
public class GoodController {
    @Autowired
    ShopService shopService;

    @GetMapping("/good")
    public ResponseEntity<List<Good>> getGood(){
        List<Good> goods = shopService.getGood();
        return ResponseEntity.ok(goods);

    }

    @PostMapping("/good")
    public ResponseEntity createAcgOrders(@RequestBody Good good) {
        shopService.create(good);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
