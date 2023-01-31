package com.shop.shopWithBaskets.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(url="http://localhost:8084")
public interface ProductsFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getAvailableProducts/{productName}", consumes = "application/json")
    ResponseEntity<ProductResponse> getAvailableProducts(@PathVariable List<String> productName);
}
