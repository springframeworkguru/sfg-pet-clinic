/**
 * 
 */
package guru.springframework.sfgpetclinic.services.interfaces;

import guru.springframework.sfgpetclinic.model.Person;

/**
 * @author Hoek0024 on 17 feb. 2023
 *
 */
public interface PersonService extends BaseEntityService {

	Person findByFirstName(String firstName);
	
	Person findByLastName(String lastName);
}
