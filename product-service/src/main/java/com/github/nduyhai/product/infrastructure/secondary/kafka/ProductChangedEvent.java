package com.nduyhai.product.infrastructure.secondary.kafka;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.event.types.DomainEvent;
import org.springframework.modulith.events.Externalized;

@Externalized(value = "ProductChangedEvent")
@Getter
@Setter
public class ProductChangedEvent implements DomainEvent {
  private UUID productId;
  private String name;
  private String sku;
  private String description;
  private String category;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
