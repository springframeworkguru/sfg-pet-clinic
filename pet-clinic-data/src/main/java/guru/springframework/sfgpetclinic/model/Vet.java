package guru.springframework.sfgpetclinic.model;

/**
 * Created by jt on 7/13/18.
 */
public class Vet extends Person {
	
	private Set<Speciality> specialities;

	/**
	 * @return the specialities
	 */
	public Set<Speciality> getSpecialities() {
		return this.specialities;
	}

	/**
	 * @param specialities the specialities to set
	 */
	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
}
