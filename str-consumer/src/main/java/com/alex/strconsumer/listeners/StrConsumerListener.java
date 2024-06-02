package com.alex.strconsumer.listeners;

import com.alex.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {
    /*@KafkaListener(
            groupId = "group-1",
            //topics = "str-topic", //O Kafka que irá gerenciar qual topico irá consumir
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"0"})
            },
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )*/
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) throws Exception {
        log.info("CREATE ::: Receive message {}", message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

    /*@KafkaListener(
            groupId = "group-1",
            //topics = "str-topic",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"1"})
            },
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )*/
    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Receive message {}", message);
    }

    /*@KafkaListener(
            groupId = "group-2",
            topics = "str-topic",
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )*/
    @KafkaListener (groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message){
        log.info("HISTORY ::: Receive message {}", message);
    }
}
