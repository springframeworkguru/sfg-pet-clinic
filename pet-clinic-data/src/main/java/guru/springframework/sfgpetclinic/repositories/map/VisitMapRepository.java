package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("map")
public class VisitMapRepository extends CrudMapRepository<Visit,Long> implements VisitRepository {
}
