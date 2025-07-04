package com.booksys.hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDTO {
        private UUID id;
        private String name;
        private String address;
        private String phone;
        private String email;
        private String description;
        private Double rating;
    }
