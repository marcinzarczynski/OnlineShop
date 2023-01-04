package com.shop.shopWithBaskets.service;

import com.shop.shopWithBaskets.entity.Basket;
import com.shop.shopWithBaskets.repository.BasketRepository;
import com.shop.shopWithBaskets.request.CreateBasketRequest;
import com.shop.shopWithBaskets.response.BasketResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketResponse addBasket(final CreateBasketRequest createBasketRequest) {
        return new BasketResponse(basketRepository.save(Basket
                .builder()
                .orderId(createBasketRequest.getOrderId())
                .items(createBasketRequest.getItems())
                .totalPrice(createBasketRequest.getTotalPrice())
                .build()));
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
