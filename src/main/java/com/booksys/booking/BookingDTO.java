package com.booksys.booking;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO (Data Transfer Object) for transferring booking data between client and server.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {

    private UUID guestId;

    private UUID roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String status; // CONFIRMED, CANCELLED, COMPLETED, etc.
}
