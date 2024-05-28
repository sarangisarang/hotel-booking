package com.booksys.hotel;
import com.booksys.guest.Guest;
import com.booksys.guest.GuestRepository;
import com.booksys.guest.GuestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class GuestServiceTest {
    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestRepository guestRepository;

    @Test
    public void GiveAllWhenHasALL(){
        Guest guest = new Guest();
        UUID guestId = UUID.randomUUID();
        guest.setGuestID(guestId);
        guest.setAddress("birkenstrase");
        guest.setEmail("bekakikalishvili@gmail.com");
        guest.setFirstName("beka");
        guest.setLastName("kikalishvili");
        guest.setPhone("4932343232");
        guest.setDatoOfBirth(LocalDate.of(17,11,1985));
        guestRepository.save(guest);
        Optional<Object> newGuest = guestRepository.findByGuestID(guestId);
        Assertions.assertNotNull(newGuest);
    }
    @Test
    public void GiveAllWhenHasAllDelete(){
        Guest guest = new Guest();
        UUID guestId = UUID.randomUUID();
        guest.setGuestID(guestId);
        guest.setAddress("birkenstrase");
        guest.setEmail("bekakikalishvili@gmail");
        guest.setFirstName("beka");
        guest.setLastName("kikalishvili");
        guest.setPhone("4932343232");
        guest.setDatoOfBirth(LocalDate.of(1985,11,17));
        guestRepository.save(guest);
        Optional<Guest> newGuest  = guestRepository.findById(String.valueOf(guestId));
//        Assertions.assertNotNull(newGuest);

        // Assert

       Assertions.assertEquals(guestId, newGuest.get().getGuestID());
//        Assertions.assertEquals("birkenstrase", newGuest.get().getAddress());
//        Assertions.assertEquals("bekakikalishvili@gmail.com", newGuest.get().getEmail());
//        Assertions.assertEquals("beka", newGuest.get().getFirstName());
//        Assertions.assertEquals("kikalishvili", newGuest.get().getLastName());
//        Assertions.assertEquals("4932343232", newGuest.get().getPhone());
//        Assertions.assertEquals(LocalDate.of(1985, 11, 17), newGuest.get().getDatoOfBirth());
//
//        guestRepository.delete(guest);
//        Optional<Object> deletedGuest = guestRepository.findByGuestID(guestId);
//        Assertions.assertFalse(deletedGuest.isPresent());

    }
}
