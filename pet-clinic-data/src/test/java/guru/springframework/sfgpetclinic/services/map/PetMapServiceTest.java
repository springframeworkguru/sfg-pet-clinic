package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 test.
 *
 * @author <a href="mailto:k.czechowski83@gmail.com">Krzysztof Czechowski</a>
 */

class PetMapServiceTest {

    private PetMapService petMapService;

    private final Long petId = 1L;

    @BeforeEach
    void setUp() {

        petMapService = new PetMapService();

        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {

        Set<Pet> petSet = petMapService.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void findByIdExistingId() {

        Pet pet = petMapService.findById(petId);

        assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {

        Pet pet = petMapService.findById(5L);

        assertNull(pet);
    }

    @Test
    void findByIdNullId() {

        Pet pet = petMapService.findById(null);

        assertNull(pet);
    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Pet pet2 = Pet.builder().id(id).build();

        Pet savedPet = petMapService.save(pet2);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {

        Long id = 1L;

        Pet pet2 = Pet.builder().id(id).build();

        Pet savedPet = petMapService.save(pet2);

        assertEquals(id, savedPet.getId());
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        Pet savedPet = petMapService.save(Pet.builder().build());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void deletePet() {

        petMapService.delete(petMapService.findById(petId));

        assertEquals(0, petMapService.findAll().size());

    }

    @Test
    void deleteWithWrongId() {

        Pet pet = Pet.builder().id(5L).build();

        petMapService.delete(pet);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        Pet pet = Pet.builder().build();

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

        petMapService.deleteById(petId);

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