package com.booksys.roomtype;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Entity representing a type/category of Room (e.g., Single, Double, Suite).
 */
@Entity
@Table(name = "room_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomType {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}
