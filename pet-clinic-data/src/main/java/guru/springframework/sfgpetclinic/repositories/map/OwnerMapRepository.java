package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Profile("map")
@Repository
public class OwnerMapRepository extends CrudMapRepository<Owner, Long> implements OwnerRepository {

    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerMapRepository(PetTypeRepository petTypeRepository, PetRepository petRepository) {
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public <S extends Owner> S save(S s) {
        if (s != null) {
            if (s.getPets() != null) {
                s.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeRepository.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petRepository.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(s);
        } else {
            return null;
        }
    }

    @Override
    public Owner findByLastName(String lastName) {
        Iterable<Owner> owners = this.findAll();
        Set<Owner> ownerSet = new HashSet<>();
        owners.forEach(ownerSet::add);
        return ownerSet
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}
