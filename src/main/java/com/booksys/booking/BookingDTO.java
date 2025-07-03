package com.booksys.booking;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * BookingDTO is a Data Transfer Object for sending booking data to the frontend.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {

    private UUID id;

    private UUID guestId;
    private String guestName; // Frontend display

    private UUID roomId;
    private String roomNumber; // Frontend display

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal totalAmount;
    private String paymentStatus;
}