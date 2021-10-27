package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("map")
public class SpecialtyMapRepository extends CrudMapRepository<Speciality, Long> implements SpecialtyRepository {
}
