package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author jt
 * @author <a href="https://www.github.com/yonatankarp>Yonatan Karp-Rudin</a>
 */
class OwnerMapServiceTest {

    private static final Long OWNER_ID = 1L;
    private static final String LAST_NAME = "Smith";

    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
    }

    @Test
    void findAll() {
        final var ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findByExistingId() {
        final var owner = ownerMapService.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByIdNotExistingId() {

        final var owner = ownerMapService.findById(5L);

        assertNull(owner);
    }

    @Test
    void findByIdNullId() {

        final var owner = ownerMapService.findById(null);

        assertNull(owner);
    }

    @Test
    void saveExistingId() {
        final Long id = 2L;

        final var owner2 = Owner.builder().id(id).build();

        final var savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveDuplicateId() {

        final Long id = 1L;

        final var owner2 = Owner.builder().id(id).build();

        final var savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        final var savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteOwner() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {

        final var owner = Owner.builder().id(5L).build();

        ownerMapService.delete(owner);

        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        final var owner = Owner.builder().build();

        ownerMapService.delete(owner);

        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        ownerMapService.delete(null);

        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void deleteByIdCorrectId() {
        ownerMapService.deleteById(OWNER_ID);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        ownerMapService.deleteById(5L);

        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        ownerMapService.deleteById(null);

        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        final var smith = ownerMapService.findByLastName(LAST_NAME);

        assertNotNull(smith);

        assertEquals(OWNER_ID, smith.getId());
        assertEquals(LAST_NAME, smith.getLastName());
    }

    @Test
    void findByLastNameLowerCase() {
        final var smith = ownerMapService.findByLastName(LAST_NAME.toLowerCase());

        assertNotNull(smith);

        assertEquals(OWNER_ID, smith.getId());
        assertEquals(LAST_NAME, smith.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        final var smith = ownerMapService.findByLastName("foo");

        assertNull(smith);
    }
}
