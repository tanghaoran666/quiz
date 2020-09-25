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
public class Good {
    @NotNull
    private String name;
    @NotNull
    @Min(0)
    private double price;
    @NotNull
    private String url;
}
