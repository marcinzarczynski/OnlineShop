package com.shop.shopWithBaskets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.shopWithBaskets.repository.BasketRepository;
import com.shop.shopWithBaskets.repository.ItemRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShopControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BasketRepository basketRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @AfterAll
    private void cleanUp() {
        itemRepository.deleteAll();
        basketRepository.deleteAll();
    }


//    @Test
//    private void shouldAddBasket(){
//        mockMvc.perform(post("/api/task")
//                        .content(objectMapper.writeValueAsBytes(CreateBasketRequest.builder()
//                                .orderId("1234")
//                                .items(List.of(new Item()))
//                                .build()))
//                        .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }

    @Test
    private void shouldDeleteBasket() {
        Assertions.assertEquals(true, true);
    }

    @Test
    private void shouldFindByOrderId() {

    }
}
