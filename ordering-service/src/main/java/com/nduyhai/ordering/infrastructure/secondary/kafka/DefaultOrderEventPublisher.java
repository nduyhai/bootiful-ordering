package com.nduyhai.ordering.infrastructure.secondary.kafka;

import com.nduyhai.ordering.domain.Order;
import com.nduyhai.ordering.domain.OrderEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultOrderEventPublisher implements OrderEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void publishEvent(Order order) {
    OrderChangedEvent event = OrderChangedEvent.fromDomain(order);

    this.applicationEventPublisher.publishEvent(event);
  }
}
