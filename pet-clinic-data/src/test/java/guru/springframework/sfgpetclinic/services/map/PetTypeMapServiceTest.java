package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="https://www.github.com/yonatankarp>Yonatan Karp-Rudin</a>
 */
class PetTypeMapServiceTest {

    private static final Long PET_TYPE_ID = 1L;

    private PetTypeMapService petTypeMapService;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();

        petTypeMapService.save(PetType.builder().id(PET_TYPE_ID).build());
    }

    @Test
    void findAll() {
        final var petTypes = petTypeMapService.findAll();
        assertEquals(1, petTypes.size());
    }

    @Test
    void findByExistingId() {
        final var petType = petTypeMapService.findById(PET_TYPE_ID);
        assertEquals(PET_TYPE_ID, petType.getId());
    }

    @Test
    void findByNotExistingId() {
        final var petType = petTypeMapService.findById(5L);
        assertNull(petType);
    }

    @Test
    void findByIdNullId() {
        final var petType = petTypeMapService.findById(null);
        assertNull(petType);
    }

    @Test
    void saveExistingId() {
        final Long id = 2L;

        final var petType2 = PetType.builder().id(id).build();

        final var savedPet = petTypeMapService.save(petType2);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {

        final Long id = 1L;

        final var petType2 = PetType.builder().id(id).build();

        final var savedPet = petTypeMapService.save(petType2);

        assertEquals(id, savedPet.getId());
        assertEquals(1, petTypeMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        final var savedPet = petTypeMapService.save(PetType.builder().build());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petTypeMapService.findAll().size());
    }

    @Test
    void deletePetType() {

        petTypeMapService.delete(petTypeMapService.findById(PET_TYPE_ID));

        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {

        final var petType = PetType.builder().id(5L).build();

        petTypeMapService.delete(petType);

        assertEquals(1, petTypeMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        final var petType = PetType.builder().build();

        petTypeMapService.delete(petType);

        assertEquals(1, petTypeMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        petTypeMapService.delete(null);

        assertEquals(1, petTypeMapService.findAll().size());

    }

    @Test
    void deleteByIdCorrectId() {

        petTypeMapService.deleteById(PET_TYPE_ID);

        assertEquals(0, petTypeMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        petTypeMapService.deleteById(5L);

        assertEquals(1, petTypeMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        petTypeMapService.deleteById(null);

        assertEquals(1, petTypeMapService.findAll().size());
    }
}
