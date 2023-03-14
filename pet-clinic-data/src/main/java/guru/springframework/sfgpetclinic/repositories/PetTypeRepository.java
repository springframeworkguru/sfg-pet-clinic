/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.PetType;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
