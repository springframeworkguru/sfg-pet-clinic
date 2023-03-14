/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.interfaces.VetService;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
@Service
@Profile("jpa")
public class VetSDJpaService<T extends Vet, R extends VetRepository<Vet>> extends PersonSDJpaService<Vet, R>
		implements VetService {

	/**
	 * @param repository
	 */
	public VetSDJpaService(R repository) {
		super(repository);
	}

}
