package org.alidi.alidiproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    @NotNull(message = "Product id is empty")
    protected Integer id;

    @Min(value = 1,message = "count must be greater than 0")
    @NotNull(message = "Product count is empty")
    protected Integer count;
}
