package com.nduyhai.inventory.domain;

import java.util.UUID;

public record ReservedStock(UUID productId, int quantity) {}
