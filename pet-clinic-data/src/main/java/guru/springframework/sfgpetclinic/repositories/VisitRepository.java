/**
 * 
 */
package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Visit;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
