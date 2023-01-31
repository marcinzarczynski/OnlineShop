package com.shop.shopWithBaskets.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class ProductResponse {

    private String name;
    private float value;

}
