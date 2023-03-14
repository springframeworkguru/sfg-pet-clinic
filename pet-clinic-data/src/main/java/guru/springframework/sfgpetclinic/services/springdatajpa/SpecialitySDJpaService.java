/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.interfaces.SpecialityService;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
@Service
@Profile("jpa")
public class SpecialitySDJpaService<T extends Speciality, R extends SpecialityRepository<Speciality>>
extends AbstractBaseEntitySDJpaService<Speciality, R> implements SpecialityService {
	
	/**
	 * @param repository
	 */
	public SpecialitySDJpaService(R repository) {
		super(repository);
	}

}
