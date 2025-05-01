package com.api.PaySwift.controller;

import com.api.PaySwift.dto.RequestPaymentDto;
import com.api.PaySwift.service.PaymentIntegrationService;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestPayment {

    @Autowired
    private PaymentIntegrationService integrationService;

    @PostMapping("/payments")
    public ResponseEntity effectivePayment(@Valid @RequestBody RequestPaymentDto dto) {
        var response = this.integrationService.intregationPayment(dto);

        return ResponseEntity.ok().body("Payment processed");
    }
}
