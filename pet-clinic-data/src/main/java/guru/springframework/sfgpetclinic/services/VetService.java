/**
 * 
 */
package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;

/**
 * @author Hoek0024 on 14 feb. 2023
 *
 */
public interface VetService {
	Vet findByLastName(String lastName);
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
