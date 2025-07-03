package com.booksys.guest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.booksys.guest.Guest;
import com.booksys.guest.GuestDTO;

/**
 GuestMapper handles automatic conversion between Guest entity and GuestDTO
 using MapStruct for clean separation of layers.
 */
@Mapper(componentModel = "spring")
public interface GuestMapper {

    GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    GuestDTO toDTO(Guest guest);

    Guest toEntity(GuestDTO guestDTO);
 }