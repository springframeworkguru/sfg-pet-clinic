package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("map")
public class VetMapRepository extends CrudMapRepository<Vet, Long> implements VetRepository {

    private final SpecialtyRepository specialtyRepository;

    public VetMapRepository(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public <S extends Vet> S save(S s) {
        if (s.getSpecialities().size() > 0) {
            s.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpecialty = specialtyRepository.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(s);
    }
}
