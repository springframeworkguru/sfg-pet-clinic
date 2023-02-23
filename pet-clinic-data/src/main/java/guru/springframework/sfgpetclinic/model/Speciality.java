/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

/**
 * @author Hoek0024 on 23 feb. 2023
 *
 */
public class Speciality extends BaseEntity {
	
	private String description;

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

}
