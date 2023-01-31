package com.shop.shopWithBaskets.repository;

import com.shop.shopWithBaskets.entity.Basket;
import com.shop.shopWithBaskets.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {

    Optional<Item> findByItemId(String id);
}
