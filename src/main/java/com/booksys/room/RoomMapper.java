package com.booksys.room;
import com.booksys.hotel.Hotel;
import com.booksys.roomtype.RoomType;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setRoomStatus(room.getRoomStatus());
        dto.setHotelId(room.getHotel() != null ? room.getHotel().getId() : null);
        dto.setRoomTypeId(room.getRoomType() != null ? room.getRoomType().getId() : null);
        return dto;
    }

    public Room toEntity(RoomDTO dto) {
        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setRoomStatus(dto.getRoomStatus());

        Hotel hotel = new Hotel();
        hotel.setId(dto.getHotelId());
        room.setHotel(hotel);

        RoomType roomType = new RoomType();
        roomType.setId(dto.getRoomTypeId());
        room.setRoomType(roomType);

        return room;
    }

}
