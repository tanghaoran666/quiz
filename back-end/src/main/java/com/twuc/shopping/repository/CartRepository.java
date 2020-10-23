package com.twuc.shopping.repository;

import com.twuc.shopping.po.CartPo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<CartPo, Integer> {
    @Override
    List<CartPo> findAll();
}
