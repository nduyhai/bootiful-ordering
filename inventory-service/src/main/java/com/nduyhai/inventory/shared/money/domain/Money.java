package com.nduyhai.inventory.shared.money.domain;

import com.nduyhai.inventory.shared.enumeration.domain.CurrencyCode;
import java.math.BigDecimal;

public record Money(BigDecimal amount, CurrencyCode currency) {}
