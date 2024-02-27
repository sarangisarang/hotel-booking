package com.booksys.hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    List<Hotel> findAllByHotelName(String hotelName);
}
