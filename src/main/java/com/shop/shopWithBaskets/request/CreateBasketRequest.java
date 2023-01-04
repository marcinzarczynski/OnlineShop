package com.shop.shopWithBaskets.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketRequest {

    private String orderId;
    private Float totalPrice;
    @NotNull(message = "item must be selected")
    private List<Long> items;

}
