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

  @KafkaListener(topics = "OrderChangedEvent")
  public void onConfirmedEvent(OrderChangedEvent orderChangedEvent) {
    log.info("Received order changed event: {}", orderChangedEvent);

    switch (orderChangedEvent.getStatus()) {
      case CANCELED:
        {
          this.inventoryService.releaseStock(orderChangedEvent.getOrderId());
          log.info("Order confirmed {} cancelled", orderChangedEvent.getOrderId());
          break;
        }
      case CONFIRMED:
        {
          ReservedStocks reserveReq = this.orderMessagingMapper.toDomain(orderChangedEvent);

          this.inventoryService.reserveStock(
              new ReservationToCreate(
                  orderChangedEvent.getOrderId(), orderChangedEvent.getCustomerId(), reserveReq));
          log.info("Order confirmed {} confirmed", orderChangedEvent.getOrderId());
          break;
        }
      default:
        log.warn("Unknown order status: {}", orderChangedEvent.getStatus());
    }
  }
}
