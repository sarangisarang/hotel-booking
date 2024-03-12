package com.booksys.hotel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HotelService {
    Hotel save(Hotel hotel);
    void deleteHotel(UUID hotelId);
    List<Hotel> findHotelByName(String name);
    Hotel findHotelByhotelID(UUID hotelFindId);
    List<Hotel> findAll();
}
