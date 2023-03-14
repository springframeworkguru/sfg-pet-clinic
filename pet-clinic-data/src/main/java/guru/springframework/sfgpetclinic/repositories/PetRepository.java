/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Pet;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface PetRepository extends CrudRepository<Pet, Long> {

}
