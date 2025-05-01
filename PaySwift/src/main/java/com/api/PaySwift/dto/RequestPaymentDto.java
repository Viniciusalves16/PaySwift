package com.api.PaySwift.dto;

import com.api.PaySwift.enumeration.PaymentTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record RequestPaymentDto(@NotNull PaymentTypeEnum paymentType,
                                @NotNull BigDecimal value,
                                @NotBlank ClientDetails clientDetails) {

    public record ClientDetails(
            @Pattern(regexp = "^[A-ZÀ-ÿ][A-Za-zÀ-ÿ'\\s]{1,49}$", message = "Name Invalid ")
            String name,
            @Pattern(regexp = "\\d{11}", message = "Document Invalid")
            String document,
            @Email(message = "Email Invalid")
            String email) {
    }
}