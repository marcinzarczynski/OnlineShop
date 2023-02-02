package com.shop.shopWithBaskets.service;

import com.shop.shopWithBaskets.entity.Basket;
import com.shop.shopWithBaskets.entity.Item;
import com.shop.shopWithBaskets.model.basket.BasketResponse;
import com.shop.shopWithBaskets.model.basket.CreateBasketRequest;
import com.shop.shopWithBaskets.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    Logger info;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketResponse addBasket(final CreateBasketRequest createBasketRequest) {
        return new BasketResponse(basketRepository.save(Basket
                .builder()
                .orderId(createBasketRequest.getOrderId())
                .items(createBasketRequest.getItems())
                .totalPrice(isEmpty(createBasketRequest.getItems()))
                .build()));
    }
    private Float isEmpty(List<Item> items){
        if(items.isEmpty()){
            return 0F;
        } else {
            return (basketValueCalculation(items));
        }
    }

    private Float basketValueCalculation(List<Item> items) {
        float price = 0;
        for (Item item : items) {
            price = price + item.getPrice();
        }
        return price;
//        List<Float> prices = items.stream().map(Item::getPrice).collect(Collectors.toList());
//        return (float) prices.stream().mapToDouble(Float::doubleValue).sum();
    }

    public Optional<BasketResponse> findByOrderId(String id) {
        return basketRepository.findByOrderId(id).map(BasketResponse::new);
    }

    public boolean deleteBasketByOrderId(String id) {
        return basketRepository.findByOrderId(id).map(basket -> {
            basketRepository.delete(basket);
            return true;
        }).orElse(false);
    }

    private Basket saveBasket(Basket basket) {
        return basketRepository.save(basket);
    }
}
