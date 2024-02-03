package com.kafka.learning.kafka3satfeb2024.service;

import com.kafka.learning.kafka3satfeb2024.model.PosInvoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${application.configs.topic.name}")
    private String TOPIC_NAME;
    public void sendMessage(String topic, String value, String key) {
        log.info(String.format("Producing Message - key : %s , Value : %s to topic : %s", key, value, topic));
        kafkaTemplate.send(topic, value, key);
    }


    public void sendMessage(PosInvoice invoice) {
        log.info(String.format("Producing Invoice No: %s Customer Type: %s",
                invoice.getInvoiceNumber(),
                invoice.getCustomerType()));
        kafkaTemplate.send(TOPIC_NAME, invoice.getStoreID(), String.valueOf(invoice));
    }
}
