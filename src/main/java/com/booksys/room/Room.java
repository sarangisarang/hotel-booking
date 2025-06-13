package com.booksys.room;

import com.booksys.roomtype.RoomType;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

/**
 * Entity representing a Room in the hotel.
 */
@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue
    private UUID id;

    private String roomNumber;

    private boolean available;

    private double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}
