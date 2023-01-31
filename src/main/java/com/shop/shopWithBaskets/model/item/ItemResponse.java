package com.shop.shopWithBaskets.model.item;

import com.shop.shopWithBaskets.entity.Item;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponse {

    private Long itemId;
    private String name;
    private Float price;

    public ItemResponse(Item item) {
        this.itemId = item.getItemId();
        this.name = item.getName();
        this.price = item.getPrice();
    }
}
