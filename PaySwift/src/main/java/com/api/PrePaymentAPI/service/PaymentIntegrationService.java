package com.api.PrePaymentAPI.service;

import com.api.PrePaymentAPI.dto.PaymentResponseDTO;
import com.api.PrePaymentAPI.dto.RequestPaymentDto;
import com.api.PrePaymentAPI.dto.RequestTopicPayment;
import com.api.PrePaymentAPI.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentIntegrationService {
// This service handles the integration with the payment system by sending payment requests to a Kafka topic.

    private final  KafkaTemplate <String, RequestTopicPayment>kafkaTemplate;
    private final  UserRepository userRepository;

    public PaymentIntegrationService(KafkaTemplate<String, RequestTopicPayment> kafkaTemplate, UserRepository userRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> integrationPaymentService(RequestPaymentDto request) {

        if (this.userRepository.findByLogin(request.clientDetails().name()) == null)
            return ResponseEntity.badRequest().build();

        UUID paymentId = UUID.randomUUID();
        String id = paymentId.toString();

        RequestTopicPayment requestTopicPayment = new RequestTopicPayment(id, request.value(), request.paymentType().toString(), request.clientDetails().name());
        this.sendPaymentToTopic(requestTopicPayment);


        return ResponseEntity.accepted().body(new PaymentResponseDTO(requestTopicPayment.getPaymentId(), "PENDING"));
    }

    public Object sendPaymentToTopic(RequestTopicPayment request){
        return kafkaTemplate.send("Payment_Topic", request);

    }
}
