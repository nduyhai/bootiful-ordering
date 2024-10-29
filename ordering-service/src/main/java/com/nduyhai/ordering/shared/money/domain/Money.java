package com.nduyhai.ordering.shared.money.domain;

import com.nduyhai.ordering.shared.enumeration.domain.CurrencyCode;
import java.math.BigDecimal;

public record Money(BigDecimal amount, CurrencyCode currency) {}
