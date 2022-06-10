package org.alidi.alidiproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.alidi.alidiproject.dto.request.BasketRequestDto;
import org.alidi.alidiproject.dto.request.ProductRequestDto;
import org.alidi.alidiproject.dto.response.BasketResponseDto;
import org.alidi.alidiproject.dto.response.ProductResponseDto;
import org.alidi.alidiproject.service.api.BasketService;
import org.alidi.alidiproject.service.api.PriceService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final PriceService priceService;

    @Override
    public BasketResponseDto calculateBasket(BasketRequestDto basket) {
        val products = basket.getProducts().stream()
                .map(this::mapProduct)
                .collect(Collectors.toList());

        val sum = products.stream()
                .map(ProductResponseDto::getSum)
                .reduce(0f, Float::sum);

        return BasketResponseDto.builder()
                .products(products)
                .sum(sum)
                .build();
    }

    private ProductResponseDto mapProduct(ProductRequestDto product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .count(product.getCount())
                .sum(priceService.findPrice(product.getId()) * product.getCount())
                .build();
    }
}
