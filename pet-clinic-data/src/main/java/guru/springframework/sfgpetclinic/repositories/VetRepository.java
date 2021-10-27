package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 8/5/18.
 */
@Profile("spring-jpa")
public interface VetRepository extends CrudRepository<Vet, Long> {
}
