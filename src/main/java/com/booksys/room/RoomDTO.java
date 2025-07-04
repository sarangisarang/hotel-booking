package com.booksys.room;
import lombok.Data;
import java.util.UUID;

@Data
public class RoomDTO {
    private UUID id;
    private String roomNumber;
    private RoomStatus roomStatus;
    private UUID hotelId;
    private UUID roomTypeId;
}