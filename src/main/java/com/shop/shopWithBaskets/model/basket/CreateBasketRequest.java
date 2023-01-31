package com.shop.shopWithBaskets.model.basket;

import com.shop.shopWithBaskets.entity.Item;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBasketRequest {

    private String orderId;
    private Float totalPrice;
    private List<Item> items;
}
