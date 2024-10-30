package com.github.nduyhai.common.money;

import com.github.nduyhai.common.enumeration.CurrencyCode;
import java.math.BigDecimal;

public record Money(BigDecimal amount, CurrencyCode currency) {}
