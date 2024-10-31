package com.nduyhai.inventory.infrastructure.secondary.persistence.mapper;

import com.nduyhai.inventory.domain.Reservation;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.ReservationEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationPersistenceMapper {
  ReservationEntity fromDomain(Reservation reservation);

  List<ReservationEntity> fromDomain(List<Reservation> reservations);

  List<Reservation> toDomain(List<ReservationEntity> reservations);

  Reservation toDomain(ReservationEntity reservation);
}
