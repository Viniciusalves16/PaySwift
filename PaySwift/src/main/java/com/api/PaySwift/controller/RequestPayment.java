package com.api.PaySwift.controller;

import com.api.PaySwift.dto.RequestPaymentDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestPayment {


    @PostMapping("/payments")
    @Transactional
    public ResponseEntity efetivaPagamento(@Valid @RequestBody RequestPaymentDto dto) {



    }
}
