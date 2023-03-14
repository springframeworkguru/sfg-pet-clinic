/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Person;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface PersonRepository<T extends Person> extends BaseEntityRepository<T> {

	T findByFirstName(String firstName);

	T findByLastName(String firstName);
}
