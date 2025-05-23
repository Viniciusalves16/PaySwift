package com.api.PrePaymentAPI.dto;

import com.api.PrePaymentAPI.enumeration.PaymentTypeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record RequestPaymentDto(
        @NotNull PaymentTypeEnum paymentType,
        @NotNull BigDecimal value,
        @Valid @NotNull ClientDetails clientDetails) {

    public record ClientDetails(
            @Pattern(regexp = "^[A-ZÀ-ÿ][A-Za-zÀ-ÿ'\\s]{1,49}$", message = "Name Invalid")
            String name,

            @Pattern(regexp = "\\d{11}", message = "Document Invalid")
            String document,

            @Email(message = "Email Invalid")
            String email,

            @NotBlank(message = "Password cannot be blank")
            String password) {
    }
}