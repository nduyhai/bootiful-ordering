package com.nduyhai.inventory.infrastructure.secondary.persistence.repo;

import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.ReservationEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaReservationRepository extends JpaRepository<ReservationEntity, UUID> {

}
