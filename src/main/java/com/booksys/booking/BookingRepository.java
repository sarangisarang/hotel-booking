package com.booksys.booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking,String> {
    Optional<Object> findBybookingID(UUID uuid);

    Set<Booking> findByCheckInBetween(LocalDate checkin, LocalDate checkout);
}
