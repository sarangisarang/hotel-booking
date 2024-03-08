package com.booksys.hotel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Setter
@Getter
public class Hotel {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Integer stars;
    private Timestamp chechinTime;
    private Timestamp checkoutTime;
}
