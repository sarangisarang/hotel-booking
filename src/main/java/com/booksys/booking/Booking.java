package com.booksys.booking;
import com.booksys.guest.Guest;
import com.booksys.payment.Payment;
import com.booksys.payment.PaymentStatus;
import com.booksys.room.Room;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entity representing a booking in the hotel system.
 */
@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private String status; // e.g., "CONFIRMED", "CANCELLED", "COMPLETED"

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    //@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    //private Invoice invoice;
}
