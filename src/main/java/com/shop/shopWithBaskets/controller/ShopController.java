package com.shop.shopWithBaskets.controller;

import com.shop.shopWithBaskets.request.CreateBasketRequest;
import com.shop.shopWithBaskets.response.BasketResponse;
import com.shop.shopWithBaskets.service.BasketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShopController {

    final private BasketService basketService;

    public ShopController(BasketService basketService) {
        this.basketService = basketService;
    }


    @PostMapping
    public ResponseEntity<BasketResponse> addBasket(@Valid @RequestBody CreateBasketRequest createBasketRequest){
        //strzelanie w 3 serwis z informacja o produktach oraz totalprice
        return new ResponseEntity<>(basketService.addBasket(createBasketRequest), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<BasketResponse> deleteBasket(@PathVariable String orderId){
        return basketService.deleteBasketByOrderId(orderId) ?
                new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<BasketResponse> findByOrderId(@PathVariable String orderId){
        return basketService.findByOrderId(orderId).map(basket -> new ResponseEntity<>(basket, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
