package com.alex.paymentservice.service;

import com.alex.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
