/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.AbstractPerson;
import guru.springframework.sfgpetclinic.repositories.PersonRepository;
import guru.springframework.sfgpetclinic.services.interfaces.PersonService;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public abstract class AbstractPersonSDJpaService<T extends AbstractPerson, R extends PersonRepository<T>>
		extends AbstractBaseEntitySDJpaService<T, R> implements PersonService<T> {

	/**
	 * @param repository
	 */
	public AbstractPersonSDJpaService(R repository) {
		super(repository);
	}

	@Override
	public T findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

	@Override
	public T findByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}

}
