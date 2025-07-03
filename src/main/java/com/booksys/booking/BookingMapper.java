package com.booksys.booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * BookingMapper maps Booking entity to BookingDTO and vice versa using MapStruct.
 * This helps in transferring data to the frontend cleanly without exposing entity internals.
 */
@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mappings({
            @Mapping(source = "guest.id", target = "guestId"),
            @Mapping(source = "guest.firstName", target = "guestName"),
            @Mapping(source = "room.id", target = "roomId"),
            @Mapping(source = "room.roomNumber", target = "roomNumber"),
            @Mapping(source = "paymentStatus", target = "paymentStatus")
    })
    BookingDTO toDTO(Booking booking);

    /**
     * Note: Mapping from BookingDTO to Booking requires guest and room entities to be set externally
     * or requires additional services to fetch them by ID before mapping.
     */
    Booking toEntity(BookingDTO bookingDTO);
}