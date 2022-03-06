package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="https://www.github.com/yonatankarp>Yonatan Karp-Rudin</a>
 */
class VisitMapServiceTest {

    private static final Long VISIT_ID = 1L;
    private static final Long PET_ID = 10L;
    private static final Long OWNER_ID = 100L;

    private VisitMapService visitMapService;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();


        final var visit = connectVisitToPetAndOwner(Visit.builder().id(VISIT_ID).build(), OWNER_ID, PET_ID);
        visitMapService.save(visit);
    }

    @Test
    void findAll() {
        final var visits = visitMapService.findAll();
        assertEquals(1, visits.size());
    }

    @Test
    void findByExistingId() {
        final var visits = visitMapService.findById(VISIT_ID);
        assertEquals(VISIT_ID, visits.getId());
    }

    @Test
    void findByNotExistingId() {
        final var visit = visitMapService.findById(5L);
        assertNull(visit);
    }

    @Test
    void findByIdNullId() {
        final var visit = visitMapService.findById(null);
        assertNull(visit);
    }

    @Test
    void saveExistingId() {
        final Long id = 2L;

        final var visit2 = connectVisitToPetAndOwner(Visit.builder().id(id).build(), OWNER_ID, PET_ID);

        final var savedVisit = visitMapService.save(visit2);

        assertEquals(id, savedVisit.getId());
    }

    @Test
    void saveDuplicateId() {

        final Long id = 1L;

        final var visit2 = connectVisitToPetAndOwner(Visit.builder().id(id).build(), OWNER_ID, PET_ID);

        final var savedVisit = visitMapService.save(visit2);

        assertEquals(id, savedVisit.getId());
        assertEquals(1, visitMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        final var visit = connectVisitToPetAndOwner(Visit.builder().build(), OWNER_ID, PET_ID);

        final var savedVisit = visitMapService.save(visit);

        assertNotNull(savedVisit);
        assertNotNull(savedVisit.getId());
        assertEquals(2, visitMapService.findAll().size());
    }

    @Test
    void deletePetType() {

        visitMapService.delete(visitMapService.findById(VISIT_ID));

        assertEquals(0, visitMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {

        final var visit = Visit.builder().id(5L).build();

        visitMapService.delete(visit);

        assertEquals(1, visitMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        final var visit = Visit.builder().build();

        visitMapService.delete(visit);

        assertEquals(1, visitMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        visitMapService.delete(null);

        assertEquals(1, visitMapService.findAll().size());

    }

    @Test
    void deleteByIdCorrectId() {

        visitMapService.deleteById(VISIT_ID);

        assertEquals(0, visitMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        visitMapService.deleteById(5L);

        assertEquals(1, visitMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        visitMapService.deleteById(null);

        assertEquals(1, visitMapService.findAll().size());
    }

    private Visit connectVisitToPetAndOwner(final Visit visit, final Long ownerId, final Long petId) {
        final var pet = Pet.builder().id(ownerId).build();
        final var owner = Owner.builder().id(petId).build();

        pet.setOwner(owner);
        owner.getPets().add(pet);

        visit.setPet(pet);

        return visit;
    }
}
