package guru.springframework.sfgpetclinic.builder;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Visit;

import java.time.LocalDate;
import java.util.Set;

public class PetBuilder {
    private Long id;
    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
    private Set<Visit> visits;

    public static final PetBuilder builder() {
        return new PetBuilder();
    }

    public PetBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PetBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PetBuilder setPetType(PetType petType) {
        this.petType = petType;
        return this;
    }

    public PetBuilder setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public PetBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PetBuilder setVisits(Set<Visit> visits) {
        this.visits = visits;
        return this;
    }

    public Pet build() {
        return new Pet(id, name, petType, owner, birthDate, visits);
    }
}
