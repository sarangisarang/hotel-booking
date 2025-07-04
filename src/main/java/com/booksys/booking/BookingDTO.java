package com.booksys.booking;
import com.booksys.payment.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String guestName;
    private UUID roomId;
    private String roomNumber;
    private double totalAmount;
    private PaymentStatus paymentStatus;
    private BookingStatus bookingStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;
}