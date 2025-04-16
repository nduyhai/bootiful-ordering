package com.nduyhai.inventory.infrastructure.secondary.persistence.repo;

import com.nduyhai.common.enumeration.ReservationStatus;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.ReservationEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaReservationRepository extends JpaRepository<ReservationEntity, UUID> {
  List<ReservationEntity> findByOrderIdAndStatus(UUID customerId, ReservationStatus status);
}
