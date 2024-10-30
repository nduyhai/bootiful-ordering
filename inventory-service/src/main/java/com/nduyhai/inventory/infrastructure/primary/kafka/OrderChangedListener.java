package com.nduyhai.inventory.infrastructure.primary.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class OrderChangedListener {
  @KafkaListener(topics = "OrderChangedEvent")
  public void onOrderChanged(OrderChangedEvent orderChangedEvent) {
    log.info("Received order changed event: {}", orderChangedEvent);
  }
}
