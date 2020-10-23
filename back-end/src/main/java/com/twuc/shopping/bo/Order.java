package com.twuc.shopping.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String name;
    private int price;
    private int number;
    private String unit;
    private int id;

}