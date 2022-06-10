package org.alidi.alidiproject.service.impl;

import org.alidi.alidiproject.service.api.PriceService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PriceServiceImpl implements PriceService {
    private final Random rnd = new Random();

    @Cacheable("productPrice")
    public Float findPrice(Integer productId) {
        float min = 0.1f;
        float max = 100f;
        return min + rnd.nextFloat() * (max - min);
    }
}
