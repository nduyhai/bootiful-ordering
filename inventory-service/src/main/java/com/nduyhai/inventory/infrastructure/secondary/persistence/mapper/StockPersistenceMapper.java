package com.nduyhai.inventory.infrastructure.secondary.persistence.mapper;

import com.nduyhai.inventory.domain.Reservation;
import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.Transaction;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.ReservationEntity;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.StockLevelEntity;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockPersistenceMapper {
  Reservation toDomain(ReservationEntity reservationEntity);

  ReservationEntity fromDomain(Reservation reservation);

  StockLevel toDomain(StockLevelEntity stockLevelEntity);

  StockLevelEntity fromDomain(StockLevel stockLevel);

  Transaction toDomain(TransactionEntity transactionEntity);

  TransactionEntity fromDomain(Transaction transaction);
}
