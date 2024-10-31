package com.nduyhai.common.money;

import com.nduyhai.common.enumeration.CurrencyCode;
import java.math.BigDecimal;

public record Money(BigDecimal amount, CurrencyCode currency) {}
