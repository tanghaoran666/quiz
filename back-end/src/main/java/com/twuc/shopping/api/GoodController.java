package com.twuc.shopping.api;


import com.twuc.shopping.bo.Good;
import com.twuc.shopping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
}
