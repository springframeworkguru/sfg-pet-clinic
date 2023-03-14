/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.services.interfaces.PetService;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
@Service
@Profile("jpa")
public class PetSDJpaService<T extends Pet, R extends PetRepository<Pet>>
extends AbstractBaseEntitySDJpaService<Pet, R> implements PetService { 
	/**
	 * @param repository
	 */
	public PetSDJpaService(R repository) {
		super(repository);
	}


}
