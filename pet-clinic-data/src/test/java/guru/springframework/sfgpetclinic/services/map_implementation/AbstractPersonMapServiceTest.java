/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.AbstractPerson;
import lombok.experimental.SuperBuilder;

/**
 * @author Hoek0024 on 16 mrt. 2023
 *
 */
class AbstractPersonMapServiceTest {
	ConcretePersonMapService concretePersonMapService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		concretePersonMapService = new ConcretePersonMapService();

		ConcretePerson armin = ConcretePerson.builder().id(1l).firstName("Armin").lastName("van Buuren").build();
		concretePersonMapService.save(armin);

		ConcretePerson tiesto = ConcretePerson.builder().id(2l).firstName("Tijs").lastName("Verwest").build();
		concretePersonMapService.save(tiesto);
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractPersonMapService#findByLastName(java.lang.String)}.
	 */
	@Test
	void testFindByLastName() {
		AbstractPerson foundArmin = concretePersonMapService.findByLastName("van Buuren");
		assertNotNull(foundArmin);
		assertEquals(Long.valueOf(1l), foundArmin.getId());
		assertEquals("Armin", foundArmin.getFirstName());
	}
	
	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractPersonMapService#findByLastName(java.lang.String)}.
	 */
	@Test
	void testFindByLastNameNotFound() {
		AbstractPerson notFoundVanDerWal = concretePersonMapService.findByLastName("van der Wal");
		assertNull(notFoundVanDerWal);
	}


	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractPersonMapService#findByFirstName(java.lang.String)}.
	 */
	@Test
	void testFindByFirstName() {
		AbstractPerson foundTiesto = concretePersonMapService.findByFirstName("Tijs");
		assertNotNull(foundTiesto);
		assertEquals(Long.valueOf(2l), foundTiesto.getId());
		assertEquals("Verwest", foundTiesto.getLastName());
	}
	
	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.map_implementation.AbstractPersonMapService#findByLastName(java.lang.String)}.
	 */
	@Test
	void testFindByFirstNameNotFound() {
		AbstractPerson notFoundNick = concretePersonMapService.findByFirstName("Nick");
		assertNull(notFoundNick);
	}

}

class ConcretePersonMapService extends AbstractPersonMapService<AbstractPerson> {

}

@SuperBuilder
class ConcretePerson extends AbstractPerson {
}
