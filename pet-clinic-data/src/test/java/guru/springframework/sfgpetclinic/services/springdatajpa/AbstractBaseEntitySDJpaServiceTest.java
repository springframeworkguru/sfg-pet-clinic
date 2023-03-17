/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.AbstractBaseEntity;
import guru.springframework.sfgpetclinic.repositories.BaseEntityRepository;
import lombok.experimental.SuperBuilder;

/**
 * @author Hoek0024 on 17 mrt. 2023
 *
 */
@ExtendWith(MockitoExtension.class)
//sets up the JUnit5 environment for Mockito
class AbstractBaseEntitySDJpaServiceTest {
	
	@Mock
	BaseEntityRepository<ConcreteBaseEntity> baseEntityRepository;
	
	@InjectMocks
	ConcreteBaseEntitySDJpaService concreteBaseEntitySDJpaService;
	
	ConcreteBaseEntity concreteBaseEntity;
	private static final Long id = Long.valueOf(1l); 
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		concreteBaseEntity = Mockito.mock(ConcreteBaseEntity.class);
	}

	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#findAll()}.
	 */
	@Test
	void testFindAll() {
		//given
		Set<ConcreteBaseEntity> concreteBaseEntities = new HashSet<>();
		concreteBaseEntities.add(concreteBaseEntity);
		ConcreteBaseEntity concreteBaseEntity2 = Mockito.mock(ConcreteBaseEntity.class);
		concreteBaseEntities.add(concreteBaseEntity2);
		
		//when
		when(baseEntityRepository.findAll()).thenReturn(concreteBaseEntities);

		//then
		Set<ConcreteBaseEntity> foundConcreteBaseEntities = concreteBaseEntitySDJpaService.findAll();
		assertEquals(2, foundConcreteBaseEntities.size());
		verify(baseEntityRepository, times(1)).findAll();
	}
	
	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#findAll()}.
	 */
	@Test
	void testFindAllNone() {
		//when
		when(baseEntityRepository.findAll()).thenReturn(new HashSet<>());

		//then
		Set<ConcreteBaseEntity> foundNoneConcreteBaseEntities = concreteBaseEntitySDJpaService.findAll();
		assertEquals(0, foundNoneConcreteBaseEntities.size());
		verify(baseEntityRepository, times(1)).findAll();
	}

	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#findById(java.lang.Object)}.
	 */
	@Test
	void testFindById() {
		//when
		when(baseEntityRepository.findById(id)).thenReturn(Optional.of(concreteBaseEntity));

		//then
		ConcreteBaseEntity foundConcreteBaseEntity = concreteBaseEntitySDJpaService.findById(id);
		assertEquals(concreteBaseEntity, foundConcreteBaseEntity);
		verify(baseEntityRepository, times(1)).findById(id);
	}
	
	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#findById(java.lang.Object)}.
	 */
	@Test
	void testFindByIdNotFound() {
		//when
		when(baseEntityRepository.findById(id)).thenReturn(Optional.empty());

		//then
		ConcreteBaseEntity notFoundConcreteBaseEntity = concreteBaseEntitySDJpaService.findById(id);
		assertNull(notFoundConcreteBaseEntity);
		verify(baseEntityRepository, times(1)).findById(id);
	}


	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#save(java.lang.Object)}.
	 */
	@Test
	void testSave() {
		//when
		when(baseEntityRepository.save(concreteBaseEntity)).thenReturn(concreteBaseEntity);
		
		ConcreteBaseEntity savedConcreteBaseEntity = concreteBaseEntitySDJpaService.save(concreteBaseEntity);
		assertNotNull(savedConcreteBaseEntity);
		verify(baseEntityRepository, times(1)).save(concreteBaseEntity);
	}

	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#delete(java.lang.Object)}.
	 */
	@Test
	void testDelete() {
		concreteBaseEntitySDJpaService.delete(concreteBaseEntity);
		verify(baseEntityRepository, times(1)).delete(concreteBaseEntity);
	}

	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#deleteById(java.lang.Object)}.
	 */
	@Test
	void testDeleteById() {
		concreteBaseEntitySDJpaService.deleteById(id);
		verify(baseEntityRepository, times(1)).deleteById(id);
	}

	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#nullCheck(java.lang.Object)}.
	 */
	@Test
	void testNullCheckNoThrows() {
		assertDoesNotThrow(() -> concreteBaseEntitySDJpaService.nullCheck(concreteBaseEntity));
	}
	
	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.springdatajpa.AbstractSDJpaService#nullCheck(java.lang.Object)}.
	 */
	@Test
	void testNullCheckThrows() {
		RuntimeException thrown = assertThrows(RuntimeException.class, () -> concreteBaseEntitySDJpaService.nullCheck(null));
		
		assertTrue(thrown.getMessage().contentEquals("Entity can not be null"));
	}

}

class ConcreteBaseEntitySDJpaService extends AbstractBaseEntitySDJpaService<ConcreteBaseEntity, BaseEntityRepository<ConcreteBaseEntity>> {
	/**
	 * @param repository
	 */
	public ConcreteBaseEntitySDJpaService(BaseEntityRepository<ConcreteBaseEntity> repository) {
		super(repository);
	}

}

@SuperBuilder
class ConcreteBaseEntity extends AbstractBaseEntity {
}
