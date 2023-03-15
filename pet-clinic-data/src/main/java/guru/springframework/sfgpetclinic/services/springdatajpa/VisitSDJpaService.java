/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.interfaces.VisitService;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
@Service
@Profile("jpa")
public class VisitSDJpaService<T extends Visit, R extends VisitRepository<Visit>>
		extends AbstractBaseEntitySDJpaService<Visit, R> implements VisitService {

	/**
	 * @param repository
	 */
	public VisitSDJpaService(R repository) {
		super(repository);
	}

}
