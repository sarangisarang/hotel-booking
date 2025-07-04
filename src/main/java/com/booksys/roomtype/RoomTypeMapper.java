package com.booksys.roomtype;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RoomTypeMapper {


    public RoomTypeDTO toDTO(RoomType roomType) {
        return RoomTypeDTO.builder()
                .id(roomType.getId())
                .name(roomType.getName())
                .description(roomType.getDescription())
                .pricePerNight(roomType.getPricePerNight())
                .capacity(roomType.getCapacity())
                .build();

    }
    public RoomType toEntity(RoomTypeDTO roomTypeDTO) {
        if (roomTypeDTO == null) {
            return null;
        }

        return RoomType.builder()
                .id(roomTypeDTO.getId())
                .name(roomTypeDTO.getName())
                .description(roomTypeDTO.getDescription())
                .pricePerNight(roomTypeDTO.getPricePerNight())
                .capacity(roomTypeDTO.getCapacity())
                .build();
    }

}
