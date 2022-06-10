package org.alidi.alidiproject.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDto {
    private Integer id;
    private Integer count;
    private Float sum;
}
