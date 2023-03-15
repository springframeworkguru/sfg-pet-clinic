/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.repositories.BaseEntityRepository;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public abstract class AbstractBaseEntitySDJpaService<T extends BaseEntity, R extends BaseEntityRepository<T>>
		extends AbstractSDJpaService<T, Long, R> {

	/**
	 * @param repository
	 */
	public AbstractBaseEntitySDJpaService(R repository) {
		super(repository);
	}

}