package com.booksys.guest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class GuestServiceImpl implements GuestService{

    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public void deleteGuest(UUID id) {
       Guest guestFind = (Guest) guestRepository.findByguestID(id).orElseThrow();
       guestRepository.delete(guestFind);
    }

    @Override
    public Guest findById(UUID id) {
        return (Guest) guestRepository.findByguestID(id).orElseThrow();
    }

    @Override
    public List<Guest> findByFirstName(String firstName) {
        return guestRepository.findByfirstName(firstName);
    }

    @Override
    public Guest findAll(){
        return (Guest) guestRepository.findAll();
    }
}
