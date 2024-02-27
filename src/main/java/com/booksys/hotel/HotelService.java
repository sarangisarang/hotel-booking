package com.booksys.hotel;
import java.util.List;
import java.util.UUID;

public interface HotelService {
    Hotel save(Hotel hotel);
    void deleteHotel(UUID hotelId);
    List<Hotel> findHotelByName(String name);
    Hotel findHotelById(UUID hotelId);
}
