package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;
import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class OwnerMapServiceTest {

    private static final Long OWNER_ID_1 = 1L;
    private static final String OWNER_LAST_NAME_1 = "Smith";
    private static final Long OWNER_ID_2 = 2L;
    private static final String OWNER_LAST_NAME_2 = "Smooth";

    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(OWNER_ID_1).lastName(OWNER_LAST_NAME_1).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNER_ID_1);

        assertEquals(OWNER_ID_1, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().id(OWNER_ID_2).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(OWNER_ID_2, savedOwner.getId());

    }

    @Test
    void saveNoId() {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID_1));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID_1);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(OWNER_LAST_NAME_1);

        assertNotNull(smith);

        assertEquals(OWNER_ID_1, smith.getId());

    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerMapService.findByLastName("foo");

        assertNull(smith);
    }


    @Test
    void findByLastNameLikeInMiddleName() {
        final var owners = ownerMapService.findAllByLastNameLike("th");

        assertNotNull(owners);
        assertEquals(1, owners.size());
        final var owner = owners.iterator().next();
        assertEquals(OWNER_ID_1, owner.getId());
        assertEquals(OWNER_LAST_NAME_1, owner.getLastName());
    }

    @Test
    void findByLastNameLikeCaseInsensitive() {
        final var owners = ownerMapService.findAllByLastNameLike("smi");

        assertNotNull(owners);
        assertEquals(1, owners.size());
        final var owner = owners.iterator().next();
        assertEquals(OWNER_ID_1, owner.getId());
        assertEquals(OWNER_LAST_NAME_1, owner.getLastName());
    }

    @Test
    void findByLastNameLikeReturnsOne() {
        ownerMapService.save(Owner.builder().id(OWNER_ID_2).lastName("smooth").build());

        final var owners = ownerMapService.findAllByLastNameLike("Smi");

        assertNotNull(owners);
        assertEquals(1, owners.size());
        final var owner = owners.iterator().next();
        assertEquals(OWNER_ID_1, owner.getId());
        assertEquals(OWNER_LAST_NAME_1, owner.getLastName());
    }

    @Test
    void findByLastNameLikeReturnsMany() {
        ownerMapService.save(Owner.builder().id(OWNER_ID_2).lastName(OWNER_LAST_NAME_2).build());

        final var owners = ownerMapService.findAllByLastNameLike("Sm");

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }
}
