package com.shop.shopWithBaskets.entity;

import com.shop.shopWithBaskets.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OrderStatus orderStatus;
    private Float totalPrice;
    private List<Long> items;
}
