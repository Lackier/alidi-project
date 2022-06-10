package org.alidi.alidiproject.service.api;

import org.alidi.alidiproject.dto.request.BasketRequestDto;
import org.alidi.alidiproject.dto.response.BasketResponseDto;

public interface BasketService {
    BasketResponseDto calculateBasket(BasketRequestDto basket);
}
