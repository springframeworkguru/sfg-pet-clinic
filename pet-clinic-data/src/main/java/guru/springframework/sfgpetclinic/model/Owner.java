package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
public class Owner extends Person {

	private Set<Pet> pets;

	/**
	 * @return the pets
	 */
	public Set<Pet> getPets() {
		return this.pets;
	}

	/**
	 * @param pets the pets to set
	 */
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
