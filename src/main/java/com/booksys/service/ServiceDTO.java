package com.booksys.service;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ServiceDTO {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
}
