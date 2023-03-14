/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Pet;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface PetRepository<T extends Pet> extends BaseEntityRepository<Pet> {

}
