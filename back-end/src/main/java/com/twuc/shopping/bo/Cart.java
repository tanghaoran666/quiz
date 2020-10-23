package com.twuc.shopping.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Cart {
    @NotNull
    private String name;
    @NotNull
    @Min(1)
    private int num;
}
