package com.nduyhai.ordering.infrastructure.secondary.persistence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {}
