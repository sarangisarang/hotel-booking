package com.booksys.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
    Invoice findByBookingId(UUID bookingId); 
}