package com.alex.jsonconsumer.listener;

import com.alex.jsonconsumer.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class JsonListener {
    @SneakyThrows
    @KafkaListener(
            topics = "payment-topic",
            groupId = "create-group",
            containerFactory = "jsonContainerFactory"
    )
    public void antiFraud(@Payload Payment payment){
        log.info("Recebi o pagamento {}", payment.toString());
        Thread.sleep(2000);
        log.info("Validando fraude...");

        log.info("Compra aprovada...");
        Thread.sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(
            topics = "payment-topic",
            groupId = "pdf-group",
            containerFactory = "jsonContainerFactory"
    )
    public void pdfGenerator(@Payload Payment payment){
        Thread.sleep(3000);
        log.info("Gerando o PDF do produto id {}", payment.getId());
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(
            topics = "payment-topic",
            groupId = "email-group",
            containerFactory = "jsonContainerFactory"
    )
    public void sendEmail(){
        Thread.sleep(3000);
        log.info("Enviando email de confirmação...");
    }
}
