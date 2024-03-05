package com.booksys.room;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Room {
    @Id
//    @GeneratedValue
//    private UUID roomId;
    private String id;
    private int room;
    private int hotell;
    private int typeId;
    private String status;
}
