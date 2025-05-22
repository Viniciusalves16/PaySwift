package com.api.PaySwift.service;

import com.api.PaySwift.controller.RequestPayment;
import com.api.PaySwift.dto.RequestPaymentDto;
import com.api.PaySwift.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentIntegrationService {

    private KafkaTemplate <String, String>kafkaTemplate;
    private UserRepository userRepository;

    public PaymentIntegrationService(KafkaTemplate<String, String> kafkaTemplate, UserRepository userRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> integrationPaymentService(RequestPaymentDto request) {

        if (this.userRepository.findByLogin(request.clientDetails().name()) == null)
            return ResponseEntity.badRequest().build();

        this.ProducerPaymentTopic(request);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public Object ProducerPaymentTopic(RequestPaymentDto request){
        return kafkaTemplate.send("Payment_Topic", String.valueOf(request));

    }
}
