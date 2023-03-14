package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by jt on 7/13/18.
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
    private PetType petType;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    
    @Column(name = "birth_date")
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
