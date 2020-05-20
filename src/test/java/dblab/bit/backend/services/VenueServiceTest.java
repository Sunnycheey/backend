package dblab.bit.backend.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VenueServiceTest {
    @Autowired
    private VenueService venueService;

    @Test
    public void getAll() {
        System.out.println(venueService.findAll());
    }
}