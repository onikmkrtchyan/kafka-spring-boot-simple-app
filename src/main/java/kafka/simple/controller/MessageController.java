package kafka.simple.controller;

import kafka.simple.dto.User;
import kafka.simple.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/message")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

    @GetMapping
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
