package com.booksys.room;
import com.booksys.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room ,String> {
    Optional<Object> findAllByroomID(UUID RoomId);

    Set<Room> findAllByHotel(Hotel hotel);
}
