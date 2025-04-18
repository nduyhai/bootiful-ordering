package com.nduyhai.payment.application;

import com.nduyhai.payment.domain.Invoice;

public interface InvoiceService {

  Invoice create(Invoice invoiceToCreate);

  Invoice getById(String id);
}
