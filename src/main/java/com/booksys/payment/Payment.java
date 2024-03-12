package com.booksys.payment;
import com.booksys.booking.Booking;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private UUID paymentID;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
