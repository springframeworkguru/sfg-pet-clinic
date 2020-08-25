package guru.springframework.sfgpetclinic.builder;

import guru.springframework.sfgpetclinic.model.PetType;

public class PetTypeBuilder {
    private Long id;
    private String name;

    public static PetTypeBuilder builder() {
        return new PetTypeBuilder();
    }

    public PetTypeBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PetTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PetType build() {
        return new PetType(id, name);
    }
}
