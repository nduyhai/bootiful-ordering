package com.nduyhai.ordering.infrastructure.primary.rest;

import com.nduyhai.ordering.application.OrderService;
import com.nduyhai.ordering.domain.Order;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;
  private final RestMapper restMapper;

  @PostMapping
  public ResponseEntity<RestOrder> createOrder(@RequestBody RestOrderToCreate req) {

    Order order = this.orderService.createOrder(this.restMapper.toDomain(req));

    return ResponseEntity.ok(this.restMapper.fromDomain(order));
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<RestOrder> getOrder(@PathVariable UUID orderId) {
    Optional<Order> order = this.orderService.getOrder(orderId);
    return order
        .map(value -> ResponseEntity.ok(this.restMapper.fromDomain(value)))
        .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<Void> deleteOrder(@PathVariable UUID orderId) {
    this.orderService.cancel(orderId);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/{orderId}/confirmed")
  public ResponseEntity<Void> confirmedOrder(@PathVariable UUID orderId) {
    this.orderService.confirmed(orderId);

    return ResponseEntity.ok().build();
  }
}
