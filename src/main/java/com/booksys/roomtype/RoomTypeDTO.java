package com.booksys.roomtype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomTypeDTO {

    private UUID id;
    private String name;
    private String description;
    private Integer pricePerNight;
    private int capacity;
}
