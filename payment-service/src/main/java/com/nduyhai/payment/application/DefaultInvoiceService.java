package com.nduyhai.payment.application;

import com.nduyhai.payment.domain.Invoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultInvoiceService implements InvoiceService {

  @Override
  public Invoice create(Invoice invoiceToCreate) {
    return null;
  }

  @Override
  public Invoice getById(String id) {
    return null;
  }
}
