package com.booksys.booking;
import com.booksys.guest.Guest;
import com.booksys.room.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate checkingDate;
    private LocalDate checkoutDate;
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "guest_ID")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name= "room_Number")
    private Room room;

}
