package com.api.PaySwift.controller;

import com.api.PaySwift.dto.RequestPaymentDto;
import com.api.PaySwift.repository.UserRepository;
import com.api.PaySwift.service.PaymentIntegrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Payments", description = "operations relationated payments")
@RestController
public class RequestPayment {


    private PaymentIntegrationService integrationService;

    public RequestPayment(PaymentIntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @Operation(summary = "Process payment ")
    @PostMapping("/payments")
    public ResponseEntity<Object> effectivePayment(@RequestBody @Valid RequestPaymentDto dto) {

        return  integrationService.integrationPaymentService (dto.clientDetails().name());
    }


}
