package com.booksys.booking;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookingMapper {


    @Mapping(source = "checkInDate", target = "checkInDate")
    @Mapping(source = "checkOutDate", target = "checkOutDate")

    default BookingDTO toDTO(Booking booking) {
        if (booking == null) return null;

        return BookingDTO.builder()
                .id(booking.getId())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .paymentStatus(booking.getPaymentStatus())
                .totalAmount(booking.getTotalAmount())
                .guestId(booking.getGuest() != null ? booking.getGuest().getId() : null)
                .roomId(booking.getRoom() != null ? booking.getRoom().getId() : null)
                .guestName(booking.getGuest() != null ? booking.getGuest().getFirstName() + " " + booking.getGuest().getLastName() : "Unknown")
                .roomNumber(booking.getRoom() != null ? booking.getRoom().getRoomNumber() : "Unknown")
                .build();
    }
        default   Booking toEntity(BookingDTO dto) {
        if (dto == null) return null;

        return Booking.builder()
                .id(dto.getId())
                .checkInDate(dto.getCheckInDate())
                .checkOutDate(dto.getCheckOutDate())
                .paymentStatus(dto.getPaymentStatus())
                .totalAmount(dto.getTotalAmount())
                .bookingStatus(dto.getBookingStatus())
                .build();
    }

}