package com.shop.shopWithBaskets.response;

import com.shop.shopWithBaskets.entity.Basket;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketResponse {

    private Long id;
    private String orderId;
    private Float totalPrice;
    private List<Long> items;

    public BasketResponse(Basket basket){
        this.id = basket.getId();
        this.orderId = basket.getOrderId();
        this.totalPrice = basket.getTotalPrice();
        this.items = basket.getItems();
    }
}
