package com.booksys.roomtype;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@Entity
public class RoomType {
    @Id
    @GeneratedValue
    private UUID typeId;
    private String name;
    private String description;
    private BigDecimal pricePerNight;
    private int capacity;
}
