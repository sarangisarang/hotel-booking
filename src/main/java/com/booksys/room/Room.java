package com.booksys.room;
import com.booksys.hotel.Hotel;
import com.booksys.roomtype.RoomType;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;
}
