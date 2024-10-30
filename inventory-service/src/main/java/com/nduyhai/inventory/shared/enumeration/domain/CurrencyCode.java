package com.nduyhai.inventory.shared.enumeration.domain;

import lombok.Getter;

@Getter
public enum CurrencyCode {
  VND("Vietnamese đồng"),
  USD("United States Dollars");

  private final String displayName;

  CurrencyCode(String displayName) {
    this.displayName = displayName;
  }
}
