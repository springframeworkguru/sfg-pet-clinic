/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Person;
import guru.springframework.sfgpetclinic.services.interfaces.PersonService;

/**
 * @author Hoek0024 on 20 feb. 2023
 *
 */
public abstract class PersonMapService extends AbstractBaseEntityMapService implements PersonService {
	@Override
	public Owner findByLastName(String lastName) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByFirstName(String firstName) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
