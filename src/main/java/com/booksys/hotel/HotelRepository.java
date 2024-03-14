package com.booksys.hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    List<Hotel> findByName(String name);

    Optional<Object> findAllByhotelID(UUID hotelID);
}
