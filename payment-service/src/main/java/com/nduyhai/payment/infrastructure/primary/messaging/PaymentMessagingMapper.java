package com.nduyhai.payment.infrastructure.primary.messaging;

import com.nduyhai.payment.domain.Invoice;
import com.nduyhai.payment.domain.InvoiceItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMessagingMapper {

  Invoice map(OrderChangedEvent event);

  InvoiceItem map(LineItemEvent event);

  List<InvoiceItem> map(List<LineItemEvent> events);
}
