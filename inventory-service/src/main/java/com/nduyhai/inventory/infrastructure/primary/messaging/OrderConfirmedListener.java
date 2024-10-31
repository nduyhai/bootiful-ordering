package com.nduyhai.inventory.infrastructure.primary.messaging;

import com.nduyhai.inventory.application.InventoryService;
import com.nduyhai.inventory.domain.ReservationToCreate;
import com.nduyhai.inventory.domain.ReservedStocks;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class OrderConfirmedListener {
  private final InventoryService inventoryService;
  private final OrderMessagingMapper orderMessagingMapper;

  @KafkaListener(topics = "OrderConfirmedEvent")
  public void onConfirmedEvent(OrderConfirmedEvent orderConfirmedEvent) {
    log.info("Received order changed event: {}", orderConfirmedEvent);

    ReservedStocks reserveReq = this.orderMessagingMapper.toDomain(orderConfirmedEvent);

    this.inventoryService.reserveStock(new ReservationToCreate(orderConfirmedEvent.getCustomerId(), orderConfirmedEvent.getOrderId(), reserveReq)
    );
  }
}
