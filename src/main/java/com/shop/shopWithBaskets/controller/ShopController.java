package com.shop.shopWithBaskets.controller;


import com.shop.shopWithBaskets.model.basket.BasketResponse;
import com.shop.shopWithBaskets.model.basket.CreateBasketRequest;
import com.shop.shopWithBaskets.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ShopController {

    final private BasketService basketService;


    public ShopController(BasketService basketService) {
        this.basketService = basketService;
    }


    @PostMapping("/basket")
    public ResponseEntity<BasketResponse> addBasket(@Valid @RequestBody CreateBasketRequest createBasketRequest){
        return new ResponseEntity<>(basketService.addBasket(createBasketRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/basket")
    public ResponseEntity<BasketResponse> deleteBasket(@PathVariable String orderId){
        return basketService.deleteBasketByOrderId(orderId) ?
                new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/basket")
    public ResponseEntity<BasketResponse> findByOrderId(@PathVariable String orderId){
        return basketService.findByOrderId(orderId).map(basket -> new ResponseEntity<>(basket, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
