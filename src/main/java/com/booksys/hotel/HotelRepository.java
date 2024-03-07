package com.booksys.hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface HotelRepository extends JpaRepository<Hotel, String> {
    List<Hotel> findByName(String name);
    Optional<Object> findAllById(UUID hotelId);
}
