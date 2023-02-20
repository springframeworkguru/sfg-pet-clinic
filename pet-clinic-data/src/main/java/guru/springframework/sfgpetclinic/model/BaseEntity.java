/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

/**
 * @author Hoek0024 on 14 feb. 2023
 *
 */
public abstract class BaseEntity implements Serializable {
	
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}
