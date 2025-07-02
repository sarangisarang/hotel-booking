package com.booksys.employee;
import com.booksys.hotel.Hotel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Staff {
    @Id
    @GeneratedValue
    private UUID staffID;
    private String firstName;
    private String lastName;
    private String positions;
    private BigDecimal salary;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private LocalDate hireDate;


    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
