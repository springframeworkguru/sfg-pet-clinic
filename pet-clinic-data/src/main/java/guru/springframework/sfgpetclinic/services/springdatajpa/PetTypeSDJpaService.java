/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.interfaces.PetTypeService;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
@Service
@Profile("jpa")
public class PetTypeSDJpaService<T extends PetType, R extends PetTypeRepository<PetType>>
		extends AbstractBaseEntitySDJpaService<PetType, R> implements PetTypeService {

	/**
	 * @param repository
	 */
	public PetTypeSDJpaService(R repository) {
		super(repository);
	}

}
