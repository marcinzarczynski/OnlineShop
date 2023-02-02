package com.shop.shopWithBaskets.model.basket;

import com.shop.shopWithBaskets.entity.Basket;
import com.shop.shopWithBaskets.entity.Item;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketResponse {

    private Long id;
    @NotNull
    private String orderId;
    private Float totalPrice;
    private List<Item> items;

    public BasketResponse(Basket basket){
        this.id = basket.getBasketId();
        this.orderId = basket.getOrderId();
        this.totalPrice = basket.getTotalPrice();
        this.items = basket.getItems();
    }
}
