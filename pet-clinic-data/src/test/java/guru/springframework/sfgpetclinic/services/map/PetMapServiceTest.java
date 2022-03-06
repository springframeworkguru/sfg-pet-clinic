package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * JUnit5 test.
 *
 * @author <a href="mailto:k.czechowski83@gmail.com">Krzysztof Czechowski</a>
 * @author <a href="https://www.github.com/yonatankarp>Yonatan Karp-Rudin</a>
 */

class PetMapServiceTest {

    private PetMapService petMapService;

    private static final Long PET_ID = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();

        petMapService.save(Pet.builder().id(PET_ID).build());
    }

    @Test
    void findAll() {

        final var petSet = petMapService.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void findByIdExistingId() {

        final var pet = petMapService.findById(PET_ID);

        assertEquals(PET_ID, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {

        final var pet = petMapService.findById(5L);

        assertNull(pet);
    }

    @Test
    void findByIdNullId() {

        final var pet = petMapService.findById(null);

        assertNull(pet);
    }

    @Test
    void saveExistingId() {

        final Long id = 2L;

        final var pet2 = Pet.builder().id(id).build();

        final var savedPet = petMapService.save(pet2);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {

        final Long id = 1L;

        final var pet2 = Pet.builder().id(id).build();

        final var savedPet = petMapService.save(pet2);

        assertEquals(id, savedPet.getId());
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        final var savedPet = petMapService.save(Pet.builder().build());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void deletePet() {

        petMapService.delete(petMapService.findById(PET_ID));

        assertEquals(0, petMapService.findAll().size());

    }

    @Test
    void deleteWithWrongId() {

        final var pet = Pet.builder().id(5L).build();

        petMapService.delete(pet);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        final var pet = Pet.builder().build();

        petMapService.delete(pet);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        petMapService.delete(null);

        assertEquals(1, petMapService.findAll().size());

    }

    @Test
    void deleteByIdCorrectId() {

        petMapService.deleteById(PET_ID);

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        petMapService.deleteById(5L);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        petMapService.deleteById(null);

        assertEquals(1, petMapService.findAll().size());
    }
}
