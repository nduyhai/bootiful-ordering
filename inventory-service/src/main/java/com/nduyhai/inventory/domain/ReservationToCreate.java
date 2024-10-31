package com.nduyhai.inventory.domain;

import java.util.UUID;

public record ReservationToCreate(UUID orderId, UUID customerId, ReservedStocks items) {}
