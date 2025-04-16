package com.nduyhai.ordering.infrastructure.primary.messaging;

import com.nduyhai.ordering.application.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class ReservedInventoryListener {
  private final OrderService orderService;

  @KafkaListener(topics = "ReservedInventoryEvent")
  public void onReservedEvent(ReservedInventoryEvent reservedInventoryEvent) {
    log.info("Received inventory changed event: {}", reservedInventoryEvent);

    this.orderService.reserveInventory(
        reservedInventoryEvent.getOrderId(), reservedInventoryEvent.getStatus());
  }
}
