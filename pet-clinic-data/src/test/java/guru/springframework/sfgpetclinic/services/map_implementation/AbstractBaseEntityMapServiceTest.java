/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.AbstractBaseEntity;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 * @author Hoek0024 on 16 mrt. 2023
 *
 */
class AbstractBaseEntityMapServiceTest {

	ConcreteBaseEntityMapService concreteBaseEntityMapService;

	final Long id = Long.valueOf(1l);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		concreteBaseEntityMapService = new ConcreteBaseEntityMapService();

		ConcreteBaseEntity concreteBaseEntity = ConcreteBaseEntity.builder().id(id).build();

		concreteBaseEntityMapService.save(id, concreteBaseEntity);
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#findAll()}.
	 */
	@Test
	void testFindAll() {
		Set<ConcreteBaseEntity> concreteBaseEntity = concreteBaseEntityMapService.findAll();

		assertEquals(1, concreteBaseEntity.size());
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#findById(java.lang.Object)}.
	 */
	@Test
	void testFindById() {
		ConcreteBaseEntity baseEntity = concreteBaseEntityMapService.findById(id);

		assertEquals(id, baseEntity.getId());
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#save(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	void testSaveExistingId() {
		Long id = 2L;
		ConcreteBaseEntity baseEntity = ConcreteBaseEntity.builder().id(id).build();

		ConcreteBaseEntity savedBaseEntity = concreteBaseEntityMapService.save(baseEntity);
		assertEquals(id, savedBaseEntity.getId());
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#save(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	void testSaveNoId() {
		ConcreteBaseEntity baseEntity = ConcreteBaseEntity.builder().build();

		ConcreteBaseEntity savedBaseEntity = concreteBaseEntityMapService.save(baseEntity);
		assertNotNull(savedBaseEntity);
		assertNotNull(savedBaseEntity.getId());
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#deleteById(java.lang.Object)}.
	 */
	@Test
	void testDeleteById() {
		assertEquals(1, concreteBaseEntityMapService.findAll().size());

		concreteBaseEntityMapService.deleteById(id);

		assertEquals(0, concreteBaseEntityMapService.findAll().size());
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#delete(java.lang.Object)}.
	 */
	@Test
	void testDelete() {
		assertEquals(1, concreteBaseEntityMapService.findAll().size());

		concreteBaseEntityMapService.delete(concreteBaseEntityMapService.findById(id));

		assertEquals(0, concreteBaseEntityMapService.findAll().size());
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#nullCheck(java.lang.Object)}.
	 */
	@Test
	void testNullCheckThrow() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> concreteBaseEntityMapService.nullCheck(null));
		
		assertTrue(thrown.getMessage().contentEquals("Entity can not be null"));
	}
	
	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractMapService#nullCheck(java.lang.Object)}.
	 */
	@Test
	void testNullCheckNoThrow() {
		ConcreteBaseEntity concreteBaseEntity = ConcreteBaseEntity.builder().build();
		assertDoesNotThrow(() -> concreteBaseEntityMapService.nullCheck(concreteBaseEntity));
	}

}

@Builder
class ConcreteBaseEntityMapService extends AbstractBaseEntityMapService<ConcreteBaseEntity> {

}

@SuperBuilder
class ConcreteBaseEntity extends AbstractBaseEntity {
}
