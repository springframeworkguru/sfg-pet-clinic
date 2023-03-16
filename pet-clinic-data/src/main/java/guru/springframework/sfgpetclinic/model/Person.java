package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 7/13/18.
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person extends AbstractBaseEntity {

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

}
