package com.alex.paymentservice.resource;

import com.alex.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResource {
    @PostMapping
    ResponseEntity<Payment> payment(@RequestBody Payment payment);
}
