package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("map")
public class VisitMapRepository extends CrudMapRepository<Visit, Long> implements VisitRepository {

    @Override
    public <S extends Visit> S save(S s) {
        if (s.getPet() == null || s.getPet().getOwner() == null || s.getPet().getId() == null
                || s.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(s);
    }
}
