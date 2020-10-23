package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.bo.Cart;
import com.twuc.shopping.bo.Good;
import com.twuc.shopping.po.CartPo;
import com.twuc.shopping.po.GoodPo;
import com.twuc.shopping.repository.CartRepository;
import com.twuc.shopping.repository.GoodRepository;
import com.twuc.shopping.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ShopService shopService;
    @Autowired
    CartRepository cartRepository;

    @BeforeEach
    void setUp(){
        shopService.initAll();
    }

    @Test
    public void shouldGetCarts() throws Exception {
        CartPo cartPo = CartPo.builder().name("可乐").num(2).build();
        cartRepository.save(cartPo);


        mockMvc.perform(get("/cart"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].name",is("可乐")))
                .andExpect(jsonPath("$[0].num",is(2)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateCart() throws Exception {
        Cart cart = Cart.builder()
                .name("可乐")
                .num(5)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(cart);
        mockMvc.perform(post("/cart").contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isCreated());
        assertEquals(1, cartRepository.findAll().size());
        assertEquals("可乐",cartRepository.findAll().get(0).getName());
        assertEquals(5,cartRepository.findAll().get(0).getNum());

    }
}
