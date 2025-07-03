package com.booksys.guest;

import lombok.*; import java.time.LocalDate; import java.util.UUID;

/**

 GuestDTO is a Data Transfer Object for transferring guest data

 between the client (frontend) and the server (backend) while

 keeping entity details encapsulated. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GuestDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthDate;
}
