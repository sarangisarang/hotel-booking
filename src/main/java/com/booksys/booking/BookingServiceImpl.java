package com.booksys.booking;

import com.booksys.guest.GuestRepository;
import com.booksys.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * BookingServiceImpl implements BookingService with DTO and entity mapping for clean architecture.
 */
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);

        booking.setGuest(guestRepository.findById(bookingDTO.getGuestId())
                .orElseThrow(() -> new RuntimeException("Guest not found")));
        booking.setRoom(roomRepository.findById(bookingDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found")));

        return bookingMapper.toDTO(bookingRepository.save(booking));
    }

    @Override
    public BookingDTO updateBooking(UUID bookingId, BookingDTO bookingDTO) {
        Booking existing = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        existing.setCheckInDate(bookingDTO.getCheckInDate());
        existing.setCheckOutDate(bookingDTO.getCheckOutDate());
        existing.setTotalAmount(bookingDTO.getTotalAmount());
        existing.setPaymentStatus(bookingDTO.getPaymentStatus());

        if (bookingDTO.getGuestId() != null) {
            existing.setGuest(guestRepository.findById(bookingDTO.getGuestId())
                    .orElseThrow(() -> new RuntimeException("Guest not found")));
        }
        if (bookingDTO.getRoomId() != null) {
            existing.setRoom(roomRepository.findById(bookingDTO.getRoomId())
                    .orElseThrow(() -> new RuntimeException("Room not found")));
        }

        return bookingMapper.toDTO(bookingRepository.save(existing));
    }

    @Override
    public BookingDTO getBookingById(UUID bookingId) {
        return bookingMapper.toDTO(bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found")));
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(bookingId);
    }
}