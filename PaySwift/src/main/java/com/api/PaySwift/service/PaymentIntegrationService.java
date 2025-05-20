package com.api.PaySwift.service;

import com.api.PaySwift.dto.RequestPaymentDto;
import com.api.PaySwift.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentIntegrationService {

    private UserRepository userRepository;

    public PaymentIntegrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<Object> integrationPaymentService(String login) {

        if (this.userRepository.findByLogin(login) == null)
            return ResponseEntity.badRequest().build();


        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
