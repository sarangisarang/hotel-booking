package com.booksys.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking,String> {
    Optional<Object> findById(UUID uuid);
}
