/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Hoek0024 on 23 feb. 2023
 *
 */
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {
	
	@Column(name = "decription")
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
