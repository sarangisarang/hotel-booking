package com.booksys.payment;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;

/**
 * Repository interface for Payment entity.
 * Provides basic CRUD operations and custom queries for payments.
 */

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    /**
     * Find all payments related to a specific booking.
     *
     * @param bookingId the ID of the booking
     * @return list of payments
     */
    List<Payment> findByBookingId(UUID bookingId);
}
