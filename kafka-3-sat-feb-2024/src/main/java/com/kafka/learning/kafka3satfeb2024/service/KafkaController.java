package com.kafka.learning.kafka3satfeb2024.service;

import com.kafka.learning.kafka3satfeb2024.model.IncomingMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public String sendMessageToKafka(@RequestBody IncomingMessages incomingMessages) {
        kafkaProducerService.sendMessage(incomingMessages.getTopic(), incomingMessages.getValue(), incomingMessages.getKey());
        return String.format("Success - Message for key %s is send to kafka Topic : %s",
                incomingMessages.getKey(),
                incomingMessages.getTopic());
    }
}
