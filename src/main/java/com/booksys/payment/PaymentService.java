package com.booksys.payment;
import java.util.List;
import java.util.UUID;

public interface PaymentService {
    Payment save(Payment payment);
    void deletePaymentById(UUID payimentId);
    List<Payment> findByName(String name);
    Payment findById(UUID id);
    List<Payment> findAll();
}
