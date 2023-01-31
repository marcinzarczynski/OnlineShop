package com.shop.shopWithBaskets.service;

import com.shop.shopWithBaskets.model.item.ItemResponse;
import com.shop.shopWithBaskets.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {


    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<ItemResponse> findByOrderId(String id) {
        return itemRepository.findByItemId(id).map(ItemResponse::new);
    }
}
