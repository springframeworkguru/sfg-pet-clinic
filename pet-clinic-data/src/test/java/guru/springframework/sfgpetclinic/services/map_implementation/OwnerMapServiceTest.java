/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.interfaces.PetService;

/**
 * @author Hoek0024 on 16 mrt. 2023
 *
 */
class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;

	@Mock
	PetService petService;
	
	@Mock
	Pet petMock;
	
	@Captor
	ArgumentCaptor<Pet> captor;
	
	Long id = 1L;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		ownerMapService = new OwnerMapService(petService);
	}

	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.map_implementation.OwnerMapService#save(guru.springframework.sfgpetclinic.model.Owner)}.
	 */
	@Test
	void testSaveOwner() {
		Set<Pet> pets = new HashSet<>();
		pets.add(petMock);
		
		//given
		Owner owner = Owner.builder().id(id).pets(pets).build();
		
		//when
		Owner savedOwner = ownerMapService.save(owner);
		
		//then
		assertEquals(id, savedOwner.getId());
		verify(petService, times(1)).save(captor.capture());
		assertTrue(captor.getAllValues().get(0) == petMock);
	}
	
	/**
	 * Test method for {@link guru.springframework.sfgpetclinic.services.map_implementation.OwnerMapService#save(guru.springframework.sfgpetclinic.model.Owner)}.
	 */
	@Test
	void testSaveNullOwner() {
		Owner savedOwner = ownerMapService.save(null);

		assertNull(savedOwner);

	}

}
