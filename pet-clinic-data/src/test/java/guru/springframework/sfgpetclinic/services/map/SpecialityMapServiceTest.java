package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="https://www.github.com/yonatankarp>Yonatan Karp-Rudin</a>
 */
class SpecialityMapServiceTest {

    private static final Long SPECIALTY_ID = 1L;

    private SpecialityMapService specialityMapService;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();

        specialityMapService.save(Speciality.builder().id(SPECIALTY_ID).build());
    }

    @Test
    void findAll() {
        final var specialities = specialityMapService.findAll();
        assertEquals(1, specialities.size());
    }

    @Test
    void findByExistingId() {
        final var speciality = specialityMapService.findById(SPECIALTY_ID);
        assertEquals(SPECIALTY_ID, speciality.getId());
    }

    @Test
    void findByNotExistingId() {
        final var speciality = specialityMapService.findById(5L);
        assertNull(speciality);
    }

    @Test
    void findByIdNullId() {
        final var speciality = specialityMapService.findById(null);
        assertNull(speciality);
    }

    @Test
    void saveExistingId() {
        final Long id = 2L;

        final var speciality2 = Speciality.builder().id(id).build();

        final var savedSpecialty = specialityMapService.save(speciality2);

        assertEquals(id, savedSpecialty.getId());
    }

    @Test
    void saveDuplicateId() {

        final Long id = 1L;

        final var speciality2 = Speciality.builder().id(id).build();

        final var savedSpeciality = specialityMapService.save(speciality2);

        assertEquals(id, savedSpeciality.getId());
        assertEquals(1, specialityMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        final var savedSpeciality = specialityMapService.save(Speciality.builder().build());

        assertNotNull(savedSpeciality);
        assertNotNull(savedSpeciality.getId());
        assertEquals(2, specialityMapService.findAll().size());
    }

    @Test
    void deletePetType() {

        specialityMapService.delete(specialityMapService.findById(SPECIALTY_ID));

        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {

        final var speciality = Speciality.builder().id(5L).build();

        specialityMapService.delete(speciality);

        assertEquals(1, specialityMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        final var speciality = Speciality.builder().build();

        specialityMapService.delete(speciality);

        assertEquals(1, specialityMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        specialityMapService.delete(null);

        assertEquals(1, specialityMapService.findAll().size());

    }

    @Test
    void deleteByIdCorrectId() {

        specialityMapService.deleteById(SPECIALTY_ID);

        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        specialityMapService.deleteById(5L);

        assertEquals(1, specialityMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        specialityMapService.deleteById(null);

        assertEquals(1, specialityMapService.findAll().size());
    }
}
