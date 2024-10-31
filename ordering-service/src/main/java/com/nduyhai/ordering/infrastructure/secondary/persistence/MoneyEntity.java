package com.nduyhai.ordering.infrastructure.secondary.persistence;

import com.nduyhai.common.enumeration.CurrencyCode;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MoneyEntity implements Serializable {
  private BigDecimal amount;

  @Enumerated(value = EnumType.STRING)
  private CurrencyCode currency;
}
