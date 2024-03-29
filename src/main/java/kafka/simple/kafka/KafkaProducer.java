package kafka.simple.kafka;

import kafka.simple.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, User> jsonKafkaTemplate;

    // The sendMessage method is used to send a message to the Kafka topic.
    public void sendMessage(String message) {
        log.info(String.format("Message sent %s", message));
        kafkaTemplate.send(topicName, message);
    }

    // The sendMessage method is used to send a user data to kafka topic.
    public void sendMessage(User user) {
        log.info(String.format("Message sent -> %s", user.toString()));

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        jsonKafkaTemplate.send(message);
    }
}
