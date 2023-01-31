package com.shop.shopWithBaskets.service;

import com.shop.shopWithBaskets.model.basket.BasketResponse;
import com.shop.shopWithBaskets.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Optional<BasketResponse> findByOrderId(String id) {
        return itemRepository.findByItemId(id).map(BasketResponse::new);
    }
}
