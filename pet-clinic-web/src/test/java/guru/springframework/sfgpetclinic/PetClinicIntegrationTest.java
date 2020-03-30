package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.services.VetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PetClinicIntegrationTest {

    @Autowired
    private VetService vetService;

    @Test
    void testFindAll() {
        vetService.findAll();
        vetService.findAll(); // served from cache
    }
}
