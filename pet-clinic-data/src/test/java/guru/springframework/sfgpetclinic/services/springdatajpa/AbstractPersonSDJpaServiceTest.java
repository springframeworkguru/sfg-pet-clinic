/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.AbstractPerson;
import guru.springframework.sfgpetclinic.repositories.PersonRepository;
import lombok.experimental.SuperBuilder;

/**
 * @author Hoek0024 on 17 mrt. 2023
 *
 */
@ExtendWith(MockitoExtension.class)
class AbstractPersonSDJpaServiceTest {

	/**
	 * 
	 */
	private static final String LAST_NAME = "van Buuren";

	/**
	 * 
	 */
	private static final String FIRST_NAME = "Armin";

	@Mock
	PersonRepository<ConcretePerson> personRepository;

	@InjectMocks
	ConcretePersonSDJpaService concretePersonSDJpaService;

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractPersonSDJpaService#findByFirstName(java.lang.String)}.
	 */
	@Test
	void testFindByFirstName() {
		//given
		ConcretePerson armin = ConcretePerson.builder().id(1l).firstName(FIRST_NAME).build();
		concretePersonSDJpaService.save(armin);

		//when
		when(personRepository.findByFirstName(FIRST_NAME)).thenReturn(armin);

		//then
		ConcretePerson foundArmin = concretePersonSDJpaService.findByFirstName(FIRST_NAME);
		assertEquals(armin, foundArmin);
		verify(personRepository, times(1)).findByFirstName(FIRST_NAME);
	}
	
	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractPersonSDJpaService#findByFirstName(java.lang.String)}.
	 */
	@Test
	void testFindByFirstNameNotFound() {
		//when
		when(personRepository.findByFirstName(FIRST_NAME)).thenReturn(null);
		
		//then
		ConcretePerson notFoundArmin = concretePersonSDJpaService.findByFirstName(FIRST_NAME);
		assertNull(notFoundArmin);
		verify(personRepository, times(1)).findByFirstName(FIRST_NAME);
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractPersonSDJpaService#findByLastName(java.lang.String)}.
	 */
	@Test
	void testFindByLastName() {
		//given
		ConcretePerson vanBuuren = ConcretePerson.builder().id(1l).lastName(LAST_NAME).build();
		concretePersonSDJpaService.save(vanBuuren);

		//when
		when(personRepository.findByLastName(LAST_NAME)).thenReturn(vanBuuren);

		//then
		ConcretePerson foundVanBuuren = concretePersonSDJpaService.findByLastName(LAST_NAME);
		assertEquals(vanBuuren, foundVanBuuren);
		verify(personRepository, times(1)).findByLastName(LAST_NAME);
	}
	
	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractPersonSDJpaService#findByLastName(java.lang.String)}.
	 */
	@Test
	void testFindByLastNameNotFound() {
		//when
		when(personRepository.findByLastName(LAST_NAME)).thenReturn(null);
		
		//then
		ConcretePerson notFoundVanBuuren = concretePersonSDJpaService.findByLastName(LAST_NAME);
		assertNull(notFoundVanBuuren);
		verify(personRepository, times(1)).findByLastName(LAST_NAME);
	}

}

class ConcretePersonSDJpaService extends AbstractPersonSDJpaService<ConcretePerson, PersonRepository<ConcretePerson>> {

	/**
	 * @param repository
	 */
	public ConcretePersonSDJpaService(PersonRepository<ConcretePerson> repository) {
		super(repository);
	}

}

@SuperBuilder
class ConcretePerson extends AbstractPerson {
}