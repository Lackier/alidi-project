package org.alidi.alidiproject.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.alidi.alidiproject.dto.request.BasketRequestDto;
import org.alidi.alidiproject.dto.request.ProductRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class BasketControllerTest {
    @Autowired
    private MockMvc mvc;

    protected String toJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void basketProductListValid() throws Exception {
        BasketRequestDto basketDto = new BasketRequestDto();
        MvcResult mvcResult = mvc.perform(post("/api/basket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(basketDto))).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 400);
    }

    @Test
    public void basketProductValid() throws Exception {
        BasketRequestDto basketDto = new BasketRequestDto();
        basketDto.setProducts(new ArrayList<>());
        basketDto.getProducts().add(new ProductRequestDto(0, 5));
        basketDto.getProducts().add(new ProductRequestDto(1, 5));

        MvcResult mvcResult = mvc.perform(post("/api/basket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(basketDto))).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }
}
