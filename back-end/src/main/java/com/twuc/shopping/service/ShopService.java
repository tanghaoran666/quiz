package com.twuc.shopping.service;

import com.twuc.shopping.bo.Good;
import com.twuc.shopping.bo.Order;
import com.twuc.shopping.po.GoodPo;
import com.twuc.shopping.po.OrderPo;
import com.twuc.shopping.repository.GoodRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {
    final GoodRepository goodRepository;
    final OrderRepository orderRepository;

    public ShopService(GoodRepository goodRepository, OrderRepository orderRepository) {
        this.goodRepository = goodRepository;
        this.orderRepository = orderRepository;
    }

    public void initAll(){
        goodRepository.deleteAll();
//        orderRepository.deleteAll();

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

    public void createOrder(Order order) {
        OrderPo orderPO = OrderPo.builder()
                .name(order.getName())
                .price(order.getPrice())
                .number(order.getNumber())
                .unit(order.getUnit()).build();
        orderRepository.save(orderPO);
    }

    public List<Order> getAllOrder() {
        List<OrderPo> orderPos = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (OrderPo orderPO : orderPos) {
            Order order = Order.builder().name(orderPO.getName())
                    .price(orderPO.getPrice())
                    .number(orderPO.getNumber())
                    .unit(orderPO.getUnit()).id(orderPO.getId()).build();
            orders.add(order);
        }
        return orders;
    }
}
