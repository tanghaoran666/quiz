package com.twuc.shopping.repository;

import com.twuc.shopping.po.GoodPo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodRepository extends CrudRepository<GoodPo, Integer> {
    @Override
    List<GoodPo> findAll();
}
