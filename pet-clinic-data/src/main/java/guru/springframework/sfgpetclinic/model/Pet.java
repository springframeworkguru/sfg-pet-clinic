package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * Created by jt on 7/13/18.
 */
public class Pet extends BaseEntity {

	private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the petType
	 */
	public PetType getPetType() {
		return this.petType;
	}
	/**
	 * @param petType the petType to set
	 */
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	/**
	 * @return the owner
	 */
	public Owner getOwner() {
		return this.owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


}
