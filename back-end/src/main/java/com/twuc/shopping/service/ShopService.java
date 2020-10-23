package com.twuc.shopping.service;

import com.twuc.shopping.bo.Cart;
import com.twuc.shopping.bo.Good;
//import com.twuc.shopping.bo.Order;
import com.twuc.shopping.po.CartPo;
import com.twuc.shopping.po.GoodPo;
//import com.twuc.shopping.po.OrderPo;
import com.twuc.shopping.repository.CartRepository;
import com.twuc.shopping.repository.GoodRepository;
//import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {
    final GoodRepository goodRepository;
//    final OrderRepository orderRepository;
    final CartRepository cartRepository;

    public ShopService(GoodRepository goodRepository, CartRepository cartRepository) {
        this.goodRepository = goodRepository;
//        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
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

    public void createGood(Good good) {
        GoodPo goodPo = GoodPo.builder().name(good.getName())
                .price(good.getPrice())
                .url(good.getUrl()).build();
        goodRepository.save(goodPo);
    }

//    public void createOrder(Order order) {
//        OrderPo orderPO = OrderPo.builder()
//                .name(order.getName())
//                .price(order.getPrice())
//                .number(order.getNumber())
//                .unit(order.getUnit()).build();
//        orderRepository.save(orderPO);
//    }
//
//    public List<Order> getOrder() {
//        List<Order> orders = orderRepository.findAll().stream().map(
//                item -> {
//                    return Order.builder()
//                            .name(item.getName())
//                            .number(item.getNumber())
//                            .price(item.getPrice())
//                            .unit(item.getUnit())
//                            .build();
//                }
//        ).collect(Collectors.toList());
//
//        return orders;
//    }

    public List<Cart> getCart() {
        List<Cart> carts = cartRepository.findAll().stream().map(
                item -> {
                    return Cart.builder()
                            .name(item.getName())
                            .num(item.getNum())
                            .build();
                }
        ).collect(Collectors.toList());

        return carts;
    }

    public void createCart(Cart cart) {
        CartPo cartPo = CartPo.builder()
                .name(cart.getName())
                .num(cart.getNum()).build();
        cartRepository.save(cartPo);
    }
}
