package com.markolofu.demo.kafkakraft.simplemessaging.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 * @apiNote {@link MessageConsumerService}
*       This class is responsible for consuming messages from a Kafka topic.
    *       It listens to the topic "simple-messaging-topic" and processes incoming messages.
    *       The messages are expected to be in byte array format, which are then converted to String for processing.
    *       The class is annotated with @Service to indicate that it is a Spring service component.
    *       The @KafkaListener annotation is used to specify the topic and group ID for consuming messages.
    *       The consume method is invoked whenever a new message is available in the specified topic.
    *       The method prints the received message to the console.
    * @see org.springframework.kafka.annotation.KafkaListener   
 */


@Service
@RequiredArgsConstructor
public class MessageConsumerService {

    private final String topicName = "simple-messaging-topic";

    @KafkaListener(topics = topicName, groupId = "simple-messaging-group")
    public void consume(ConsumerRecord<String, byte[]> record) {
        
        String message = new String(record.value());

        System.out.println("Received message: " + message);
        
    }
    
}
