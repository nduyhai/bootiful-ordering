package com.github.nduyhai.common.enumeration;

public enum CurrencyCode {
  VND("Vietnamese đồng"),
  USD("United States Dollars");

  private final String displayName;

  CurrencyCode(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
