package com.api.PaySwift.controller;

import com.api.PaySwift.dto.RequestPaymentDto;
import com.api.PaySwift.service.PaymentIntegrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Payments", description = "Operações relacionadas a pagamentos")
@RestController
public class RequestPayment {

    @Autowired
    private PaymentIntegrationService integrationService;

    @Operation(summary = "Processa um pagamento efetivo")
    @PostMapping("/payments")
    public ResponseEntity<String> effectivePayment(@RequestBody @Valid RequestPaymentDto dto) {
        var response = this.integrationService.intregationPayment(dto);

        return ResponseEntity.ok("Payment processed");
    }
}
