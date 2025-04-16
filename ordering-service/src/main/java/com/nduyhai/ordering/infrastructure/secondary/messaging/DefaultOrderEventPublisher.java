package com.nduyhai.ordering.infrastructure.secondary.messaging;

import com.nduyhai.ordering.domain.Order;
import com.nduyhai.ordering.domain.OrderEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultOrderEventPublisher implements OrderEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;
  private final OrderMessagingMapper orderMessagingMapper;

  @Override
  public void onChange(Order order) {
    OrderChangedEvent event = this.orderMessagingMapper.fromDomain(order);

    this.applicationEventPublisher.publishEvent(event);
  }
}
