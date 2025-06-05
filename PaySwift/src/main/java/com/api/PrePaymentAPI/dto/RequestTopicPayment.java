package com.api.PrePaymentAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTopicPayment {

    private String paymentId;
    private BigDecimal amount;
    private String paymentMethod;
    private String clientName;
    private String email;
}
