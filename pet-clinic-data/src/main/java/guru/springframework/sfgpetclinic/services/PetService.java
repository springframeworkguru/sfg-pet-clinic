/**
 * 
 */
package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Pet;

/**
 * @author Hoek0024 on 14 feb. 2023
 *
 */
public interface PetService {
	
	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
