package com.booksys.guest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Guest {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate datoOfBirth;
    private String address;
    private String phone;
    private String email;
}
