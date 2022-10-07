package kafka.example.kafkaservice.consumer;

import kafka.example.kafkaservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    private EmailService emailService;

    @KafkaListener(
            topics = "learnTopic",
            groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Listener receive : " + data);

        emailService.send();
    }
}
