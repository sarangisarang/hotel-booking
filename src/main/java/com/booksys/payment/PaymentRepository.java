package com.booksys.payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;


public interface PaymentRepository extends JpaRepository<Payment,String> {
    Optional<Object> findByPaymentID(UUID uuid);
}
