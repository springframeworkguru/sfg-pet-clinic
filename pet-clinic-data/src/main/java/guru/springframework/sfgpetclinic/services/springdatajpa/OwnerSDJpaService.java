/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.interfaces.OwnerService;
import guru.springframework.sfgpetclinic.services.interfaces.PetService;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
@Service
@Profile("jpa")
public class OwnerSDJpaService<T extends Owner, R extends OwnerRepository<Owner>> extends PersonSDJpaService<Owner, R>
		implements OwnerService {

	/**
	 * @param repository
	 */
	public OwnerSDJpaService(R repository, PetService petservice) {
		super(repository);
	}
}
