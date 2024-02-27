package com.booksys.hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Hotel {
    @Id
    @GeneratedValue
    private UUID hotelId;
}
