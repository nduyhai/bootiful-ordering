package com.nduyhai.ordering.domain;

import com.nduyhai.ordering.shared.enumeration.domain.CurrencyCode;
import java.math.BigDecimal;

public record Money(BigDecimal amount, CurrencyCode currency) {}
