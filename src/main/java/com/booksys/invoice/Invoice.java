package com.booksys.invoice;
import com.booksys.booking.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.booksys.booking.Booking; import jakarta.persistence.*; import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor; import java.math.BigDecimal; import java.time.LocalDateTime; import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue
    private UUID id; // Auto-generated UUID for H2

    private LocalDateTime invoiceDate; // Date and time of invoice creation

    private BigDecimal amount; // Invoice total amount

    private String fileUrl; // URL for the invoice file

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false, unique = true)
    private Booking booking; // Related booking

    @PrePersist
    public void prePersist() {
        this.invoiceDate = LocalDateTime.now();
    }

}
