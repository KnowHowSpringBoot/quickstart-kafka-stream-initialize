package dev.knowhowto.kafkastreaminitialize;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
  @KafkaListener(id = "logConsumerId", topics = "${iqkv.kafka.topics.for-input.name}")
  public void listen(String in) {
    log.info("listener: {}", in);
  }

}
