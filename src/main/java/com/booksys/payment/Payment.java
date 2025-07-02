package com.booksys.payment;

import com.booksys.booking.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String paymentMethod; // e.g., "CREDIT_CARD", "CASH", "ONLINE"

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status; // e.g., "PAID", "PENDING", "FAILED"

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
