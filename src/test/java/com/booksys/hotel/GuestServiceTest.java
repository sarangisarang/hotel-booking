package com.booksys.hotel;
import com.booksys.guest.Guest;
import com.booksys.guest.GuestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class GuestServiceTest {
    @Autowired
    private GuestService guestService;

    @Test
    public void GiveAllWhenHasALL(){
        Guest guest = new Guest();
        guest.setGuestID(UUID.fromString("12345"));
        guest.setAddress("birkenstrase");
        guest.setEmail("bekakikalishvili@gmail");
        guest.setFirstName("beka");
        guest.setLastName("kikalishvili");
        guest.setPhone("4932343232");
        guest.setDatoOfBirth(LocalDate.ofEpochDay(17-11-1985));
        guestService.save(guest);
        Guest newguest  = guestService.findById(UUID.fromString("12345"));
        Assertions.assertNotNull(newguest);
    }
    @Test
    public void GiveAllWhenHasAllDelete(){
        Guest guest = new Guest();
  //      guest.setGuestID(UUID.fromString("12345"));
        guest.setAddress("birkenstrase");
        guest.setEmail("bekakikalishvili@gmail");
        guest.setFirstName("beka");
        guest.setLastName("kikalishvili");
        guest.setPhone("4932343232");
        guest.setDatoOfBirth(LocalDate.ofEpochDay(17-11-1985));
        guestService.save(guest);
        Guest newguest  = guestService.findById(UUID.fromString("12345"));
        guestService.deleteGuest(newguest.getGuestID());
        Assertions.assertNotEquals(newguest,guest);

    }
}
