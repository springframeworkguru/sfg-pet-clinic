package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by jt on 7/13/18.
 */
@MappedSuperclass // this will never be mapped as a table in the database, only the subclasses
					// under this superclass
public class Person extends BaseEntity {

	@Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
