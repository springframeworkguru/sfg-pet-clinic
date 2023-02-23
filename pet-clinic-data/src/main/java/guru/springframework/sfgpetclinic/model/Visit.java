/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * @author Hoek0024 on 23 feb. 2023
 *
 */
public class Visit extends BaseEntity {

	private LocalDate date;
	private String description;
	private Pet pet;

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pet
	 */
	public Pet getPet() {
		return this.pet;
	}

	/**
	 * @param pet the pet to set
	 */
	public void setPet(Pet pet) {
		this.pet = pet;
	}

}
