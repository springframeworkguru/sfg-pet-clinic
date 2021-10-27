package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("map")
@Repository
public class PetTypeMapRepository extends CrudMapRepository<PetType, Long> implements PetTypeRepository {
}
