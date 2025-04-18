package com.nduyhai.payment.infrastructure.primary.messaging;

import com.nduyhai.payment.application.InvoiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class OrderConfirmedListener {

  private final InvoiceService invoiceService;
  private final PaymentMessagingMapper paymentMessagingMapper;
  ;

  @KafkaListener(topics = "OrderChangedEvent")
  public void onConfirmedEvent(OrderChangedEvent orderChangedEvent) {
    log.info("Received order changed event: {}", orderChangedEvent);

    switch (orderChangedEvent.getStatus()) {
      case CANCELED:
        {
          log.info("Order confirmed {} cancelled", orderChangedEvent.getOrderId());
          break;
        }
      case PAYING:
        {
          this.invoiceService.create(this.paymentMessagingMapper.map(orderChangedEvent));
          log.info("Order confirmed {} paying", orderChangedEvent.getOrderId());
          break;
        }
      default:
        log.warn("Unknown order status: {}", orderChangedEvent.getStatus());
    }
  }
}
