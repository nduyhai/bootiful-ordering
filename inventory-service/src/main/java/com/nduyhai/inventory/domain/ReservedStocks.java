package com.nduyhai.inventory.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservedStocks {
  private List<ReservedStock> items;
}
