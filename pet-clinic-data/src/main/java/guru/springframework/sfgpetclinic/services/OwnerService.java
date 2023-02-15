/**
 * 
 */
package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

/**
 * @author Hoek0024 on 14 feb. 2023
 *
 */
public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
}
