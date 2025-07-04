package com.booksys.guest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


/**
 GuestMapper handles automatic conversion between Guest entity and GuestDTO
 using MapStruct for clean separation of layers.
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GuestMapper {

    GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    GuestDTO toDTO(Guest guest);

    Guest toEntity(GuestDTO guestDTO);
 }