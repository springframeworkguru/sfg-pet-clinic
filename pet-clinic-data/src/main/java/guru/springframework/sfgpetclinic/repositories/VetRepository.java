/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Vet;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface VetRepository extends CrudRepository<Vet, Long> {

}
