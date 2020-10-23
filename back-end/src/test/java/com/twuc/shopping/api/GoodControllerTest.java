package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.bo.Good;
import com.twuc.shopping.po.GoodPo;
import com.twuc.shopping.repository.GoodRepository;
import com.twuc.shopping.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class GoodControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired
    ShopService shopService;
    @Autowired
    GoodRepository goodRepository;

    @BeforeEach
    void setUp(){
        shopService.initAll();
    }

    @Test
    public void shouldGetGoods() throws Exception {
        for (int i = 0; i <5 ; i++) {
            GoodPo goodPo = GoodPo.builder().name("可乐"+String.valueOf(i+1)).price(1.00).url("./../images/").build();
            goodRepository.save(goodPo);
        }

        mockMvc.perform(get("/good"))
                .andExpect(jsonPath("$",hasSize(5)))
                .andExpect(jsonPath("$[0].name",is("可乐1")))
                .andExpect(jsonPath("$[0].price",is(1.00)))
                .andExpect(jsonPath("$[0].url",is("./../images/")))
                .andExpect(jsonPath("$[1].name",is("可乐2")))
                .andExpect(jsonPath("$[2].name",is("可乐3")))
                .andExpect(jsonPath("$[3].name",is("可乐4")))
                .andExpect(jsonPath("$[4].name",is("可乐5")))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateGood() throws Exception {
        Good good = Good.builder().url("./../images/")
                .price(2.00)
                .name("可乐6")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(good);
        mockMvc.perform(post("/good").contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isCreated());
        assertEquals(1, goodRepository.findAll().size());
        assertEquals("可乐6",goodRepository.findAll().get(0).getName());
        assertEquals(2.00,goodRepository.findAll().get(0).getPrice());
        assertEquals("./../images/",goodRepository.findAll().get(0).getUrl());

    }




}