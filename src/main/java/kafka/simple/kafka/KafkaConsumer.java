package kafka.simple.kafka;

import kafka.simple.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    // The @KafkaListener annotation is used to listen to the Kafka topic.
    // The consume method is used to consume the message from the Kafka topic.
    // The message logged to the console.
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info(String.format("Message received -> %s", message));
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.info(String.format("Json message received -> %s", user.toString()));
    }
}
