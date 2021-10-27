package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("map")
@Repository
public class OwnerMapRepository extends CrudMapRepository<Owner, Long> implements OwnerRepository {

    @Override
    public Owner findByLastName(String lastName) {
        System.out.println("OwnerMapRepository : findBylastName("  + lastName + ")");
        return null;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}
