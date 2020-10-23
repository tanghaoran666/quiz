package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.bo.Order;
import com.twuc.shopping.po.OrderPo;
import com.twuc.shopping.repository.GoodRepository;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired
    ShopService shopService;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setUp(){
        shopService.initAll();
    }

    @Test
    public void shouldCreateOrder() throws Exception {
        Order order = Order.builder().name("可乐1").number(1).price(1).unit("瓶").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/order").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        List<OrderPo> orderPos = orderRepository.findAll();
        assertNotNull(orderPos);
        assertEquals(1,orderPos.size());
        assertEquals("可乐1",orderPos.get(0).getName());
        assertEquals(1,orderPos.get(0).getPrice());
        assertEquals(1,orderPos.get(0).getNumber());
        assertEquals("瓶",orderPos.get(0).getUnit());
    }

    @Test
    public void should_get_all_order() throws Exception {
        Order order = Order.builder().name("可乐1").number(1).price(1).unit("瓶").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/order").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].name",is("可乐1")))
                .andExpect(jsonPath("$[0].number",is(1)))
                .andExpect(jsonPath("$[0].price",is(1)))
                .andExpect(jsonPath("$[0].unit",is("瓶")))
                .andExpect(status().isOk());
    }
}
