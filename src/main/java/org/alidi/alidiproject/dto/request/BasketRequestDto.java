package org.alidi.alidiproject.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.alidi.alidiproject.dto.enums.PaymentType;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
public class BasketRequestDto {
    @Valid
    @NotEmpty(message = "Product list is empty")
    private List<ProductRequestDto> products;

    private PaymentType paymentType;
    private Integer addressId;
}
