/**
 * 
 */
package guru.springframework.sfgpetclinic.services.interfaces;

import guru.springframework.sfgpetclinic.model.Person;

/**
 * @author Hoek0024 on 17 feb. 2023
 *
 */
public interface PersonService<T extends Person> extends BaseEntityService<T>{

	T findByFirstName(String firstName);
	
	T findByLastName(String lastName);
}
