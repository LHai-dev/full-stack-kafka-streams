package com.kafka.learning.kafka3satfeb2024.model;

import lombok.Data;

@Data
public class IncomingMessages {
    private String topic;
    private String key;
    private String value;
}
