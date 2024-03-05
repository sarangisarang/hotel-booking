package com.booksys.hotel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }
    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(UUID hotelId) {
        Hotel findHotel = hotelRepository.findById(hotelId).orElseThrow();
        hotelRepository.delete(findHotel);

    }

    @Override
    public List<Hotel> findHotelByName(String name) {
            return hotelRepository.findAllByHotelName(name);
    }

    @Override
    public Hotel findHotelById(UUID hotelId) {
        return null;
    }
}
