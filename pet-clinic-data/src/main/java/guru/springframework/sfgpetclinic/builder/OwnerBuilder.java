package guru.springframework.sfgpetclinic.builder;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public class OwnerBuilder {
    private Long id;
    private Set<Pet> pets;
    private String address;
    private String city;
    private String telephone;
    private String firstName;
    private String lastName;

    public static OwnerBuilder builder() {
        return new OwnerBuilder();
    }

    public OwnerBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public OwnerBuilder setPets(Set<Pet> pets) {
        this.pets = pets;
        return this;
    }

    public OwnerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public OwnerBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public OwnerBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public OwnerBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public OwnerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Owner build() {
        return new Owner(id, firstName, lastName, pets, address, city, telephone);
    }
}
