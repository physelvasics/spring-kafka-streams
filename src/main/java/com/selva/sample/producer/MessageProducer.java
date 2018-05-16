package com.selva.sample.producer;

import com.selva.sample.kafka.KafkaCustomProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class MessageProducer {

    @Autowired
    KafkaCustomProducer kafkaCustomProducer;

    public void pusblishMessage(String message) throws ExecutionException, InterruptedException {
        final Producer<Long, String> producer = kafkaCustomProducer.createProducer();

        long time = System.currentTimeMillis();

        final ProducerRecord<Long, String> record =
                new ProducerRecord<Long, String>("message-topic", time,
                        message);

        RecordMetadata metadata = producer.send(record).get();

    }


}
