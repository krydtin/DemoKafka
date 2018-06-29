package com.krydtin.demo.services;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        final Message<String> message = MessageBuilder
                .withPayload("hi there " + new Date().toString())
                .setHeader(KafkaHeaders.TOPIC, "testing")
                .setHeader("hi", "I'm header")
                .build();
        
        kafkaTemplate.send(message);
    }

}
