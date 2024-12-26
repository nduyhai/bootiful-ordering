package com.nduyhai.inventory.infrastructure.secondary.persistence.mapper;

import com.nduyhai.inventory.domain.Reservation;
import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.Transaction;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.ReservationEntity;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.StockLevelEntity;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.TransactionEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StockPersistenceMapper {
  Reservation toDomain(ReservationEntity reservationEntity);

  ReservationEntity fromDomain(Reservation reservation);

  @Mapping(
      target = "remainingQuantity",
      expression =
          "java(stockLevelEntity.getTotalQuantity() - stockLevelEntity.getReservedQuantity())")
  StockLevel toDomain(StockLevelEntity stockLevelEntity);

  List<StockLevel> toDomains(List<StockLevelEntity> stockLevelEntity);

  StockLevelEntity fromDomain(StockLevel stockLevel);

  Transaction toDomain(TransactionEntity transactionEntity);

  TransactionEntity fromDomain(Transaction transaction);
}
