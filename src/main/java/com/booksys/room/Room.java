package com.booksys.room;
import com.booksys.hotel.Hotel;
import com.booksys.roomtype.RoomType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue
    private UUID roomID;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private RoomType roomType;
}
