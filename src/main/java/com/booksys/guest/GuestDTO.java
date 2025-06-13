package com.booksys.guest;

import lombok.*;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for transferring guest data between client and server.
 * This class is used for receiving input data and sending response data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestDTO {

    /** Guest's first name */
    private String firstName;

    /** Guest's last name */
    private String lastName;

    /** Guest's birth date */
    private LocalDate birthDate;

    /** Guest's address */
    private String address;

    /** Guest's phone number */
    private String phone;

    /** Guest's email address */
    private String email;
}
