package com.nduyhai.payment.application;

import com.nduyhai.payment.domain.PaymentTransaction;

public interface TransactionService {
  PaymentTransaction getPaymentTransactionById(String id);
}
