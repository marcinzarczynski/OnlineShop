package com.shop.shopWithBaskets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ShopWithBasketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopWithBasketsApplication.class, args);
	}

}
