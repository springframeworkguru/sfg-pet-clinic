/**
 * 
 */
package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Hoek0024 on 14 feb. 2023
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractBaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
