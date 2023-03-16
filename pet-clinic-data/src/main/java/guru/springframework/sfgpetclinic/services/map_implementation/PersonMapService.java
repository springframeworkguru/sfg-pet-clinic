/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import guru.springframework.sfgpetclinic.model.Person;
import guru.springframework.sfgpetclinic.services.interfaces.PersonService;

/**
 * @author Hoek0024 on 20 feb. 2023
 *
 */
public abstract class PersonMapService<T extends Person> extends AbstractBaseEntityMapService<T>
		implements PersonService<T> {
	@Override
	public T findByLastName(String lastName) {
		return this.findAll().stream().filter(person -> person.getLastName().equalsIgnoreCase(lastName)).findFirst()
				.orElse(null);
	}

	@Override
	public T findByFirstName(String firstName) {
		return this.findAll().stream().filter(person -> person.getFirstName().equalsIgnoreCase(firstName)).findFirst()
				.orElse(null);
	}

}
