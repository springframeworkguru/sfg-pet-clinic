package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 8/5/18.
 */
@Profile("spring-jpa")
public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
