package org.alidi.alidiproject.rest;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.alidi.alidiproject.dto.request.BasketRequestDto;
import org.alidi.alidiproject.dto.response.BasketResponseDto;
import org.alidi.alidiproject.service.api.BasketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/basket", name = "Корзина пользователя")
@Api(value = "/basket", tags = "Корзина пользователя")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PostMapping
    @Operation(summary = "Подсчёт корзины")
    public BasketResponseDto calculateBasket(@Valid @RequestBody BasketRequestDto basket) {
        return basketService.calculateBasket(basket);
    }
}
