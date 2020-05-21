package dblab.bit.backend.services;

import dblab.bit.backend.repository.VenueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VenueServiceTest {
    @Autowired
    private VenueRepository venueService;

    @Test
    public void getAll() {
        System.out.println(venueService.findAll());
    }
}