package org.alidi.alidiproject.dto.response;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
public class BasketResponseDto {
    @Valid
    @NotEmpty(message = "Product list is empty")
    private List<ProductResponseDto> products;

    private Float sum;
}
