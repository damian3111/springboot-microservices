package org.example.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.dto.NotificationDTO;
import org.example.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class KafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(groupId = "group1", topicPartitions = @TopicPartition(topic = "topic4", partitions = "0"))
    public void kafkaListener(NotificationDTO message) {

        notificationService.sendMessage(message);
    }
}
