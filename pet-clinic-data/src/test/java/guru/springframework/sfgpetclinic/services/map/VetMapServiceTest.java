package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="https://www.github.com/yonatankarp>Yonatan Karp-Rudin</a>
 */
class VetMapServiceTest {

    private static final Long VET_ID = 1L;

    private VetMapService vetMapService;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());

        vetMapService.save(Vet.builder().id(VET_ID).build());
    }

    @Test
    void findAll() {
        final var vets = vetMapService.findAll();
        assertEquals(1, vets.size());
    }

    @Test
    void findByExistingId() {
        final var vet = vetMapService.findById(VET_ID);
        assertEquals(VET_ID, vet.getId());
    }

    @Test
    void findByNotExistingId() {
        final var vet = vetMapService.findById(5L);
        assertNull(vet);
    }

    @Test
    void findByIdNullId() {
        final var vet = vetMapService.findById(null);
        assertNull(vet);
    }

    @Test
    void saveExistingId() {
        final Long id = 2L;

        final var vet2 = Vet.builder().id(id).build();

        final var savedVet = vetMapService.save(vet2);

        assertEquals(id, savedVet.getId());
    }

    @Test
    void saveDuplicateId() {

        final Long id = 1L;

        final var vet2 = Vet.builder().id(id).build();

        final var savedVet = vetMapService.save(vet2);

        assertEquals(id, savedVet.getId());
        assertEquals(1, vetMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        final var savedVet = vetMapService.save(Vet.builder().build());

        assertNotNull(savedVet);
        assertNotNull(savedVet.getId());
        assertEquals(2, vetMapService.findAll().size());
    }

    @Test
    void deletePetType() {

        vetMapService.delete(vetMapService.findById(VET_ID));

        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {

        final var vet = Vet.builder().id(5L).build();

        vetMapService.delete(vet);

        assertEquals(1, vetMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        final var vet = Vet.builder().build();

        vetMapService.delete(vet);

        assertEquals(1, vetMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        vetMapService.delete(null);

        assertEquals(1, vetMapService.findAll().size());

    }

    @Test
    void deleteByIdCorrectId() {

        vetMapService.deleteById(VET_ID);

        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        vetMapService.deleteById(5L);

        assertEquals(1, vetMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        vetMapService.deleteById(null);

        assertEquals(1, vetMapService.findAll().size());
    }
}
