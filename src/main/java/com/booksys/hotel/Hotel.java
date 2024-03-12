package com.booksys.hotel;
import com.booksys.room.Room;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;


@Entity
@Setter
@Getter
public class Hotel {
    @Id
    @GeneratedValue
    private UUID hotelID;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Integer stars;
    private Timestamp chechinTime;
    private Timestamp checkoutTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel")
    private Set<Room> rooms;
}
