package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
public class Owner extends Person {

	private String address;
	private String city;
	private String telephone;
	private Set<Pet> pets;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the pets
	 */
	public Set<Pet> getPets() {
		return this.pets;
	}

	/**
	 * @param pets the pets to set
	 */
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
