package com.booksys.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for Hotel entity.
 */
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    boolean existsByName(String name);
}

