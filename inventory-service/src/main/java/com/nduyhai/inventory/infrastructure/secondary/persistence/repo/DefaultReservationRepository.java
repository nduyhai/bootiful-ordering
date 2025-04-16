package com.nduyhai.inventory.infrastructure.secondary.persistence.repo;

import com.nduyhai.common.enumeration.ReservationStatus;
import com.nduyhai.inventory.domain.Reservation;
import com.nduyhai.inventory.domain.ReservationRepository;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.ReservationEntity;
import com.nduyhai.inventory.infrastructure.secondary.persistence.mapper.ReservationPersistenceMapper;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultReservationRepository implements ReservationRepository {
  private final JpaReservationRepository jpaReservationRepository;
  private final ReservationPersistenceMapper reservationPersistenceMapper;

  @Override
  public Reservation save(Reservation reservation) {
    ReservationEntity savedEntity =
        this.jpaReservationRepository.save(
            this.reservationPersistenceMapper.fromDomain(reservation));

    return this.reservationPersistenceMapper.toDomain(savedEntity);
  }

  @Override
  public List<Reservation> saveAll(List<Reservation> reservations) {
    List<ReservationEntity> reservationEntities =
        jpaReservationRepository.saveAll(
            this.reservationPersistenceMapper.fromDomain(reservations));
    return this.reservationPersistenceMapper.toDomain(reservationEntities);
  }

  @Override
  public List<Reservation> findByOrderIdAndStatus(UUID orderId, ReservationStatus status) {
    List<ReservationEntity> reservationEntities =
        this.jpaReservationRepository.findByOrderIdAndStatus(orderId, status);
    return this.reservationPersistenceMapper.toDomain(reservationEntities);
  }
}
