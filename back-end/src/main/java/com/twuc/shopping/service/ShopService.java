package com.twuc.shopping.service;

import com.twuc.shopping.bo.Good;
import com.twuc.shopping.po.GoodPo;
import com.twuc.shopping.repository.GoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ShopService {
    final GoodRepository goodRepository;

    public ShopService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    public void initAll(){
        goodRepository.deleteAll();

    }

    public List<Good> getGood() {
        List<Good> goods = goodRepository.findAll().stream().map(
                item -> {
                    return Good.builder().name(item.getName())
                            .price(item.getPrice())
                            .url(item.getUrl()).build();
                }
        ).collect(Collectors.toList());

        return goods;
    }

    public void create(Good good) {
        GoodPo goodPo = GoodPo.builder().name(good.getName())
                .price(good.getPrice())
                .url(good.getUrl()).build();
        goodRepository.save(goodPo);
    }
}
