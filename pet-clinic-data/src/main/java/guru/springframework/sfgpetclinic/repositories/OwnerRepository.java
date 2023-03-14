/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Owner;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
