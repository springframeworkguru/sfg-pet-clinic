/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Vet;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface VetRepository<T extends Vet> extends PersonRepository<Vet> {

}
