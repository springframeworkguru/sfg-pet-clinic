/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.interfaces.OwnerService;
import guru.springframework.sfgpetclinic.services.interfaces.PetService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@Service
public class OwnerMapService extends PersonMapService<Owner> implements OwnerService {

	private final PetService petService;

	/**
	 * @param petTypeService
	 * @param petService
	 */
	public OwnerMapService(PetService petService) {
		this.petService = petService;
	}

	@Override
	public Owner save(Owner owner) {
		if (owner == null) {
			return null;
		}
				
		owner.getPets().forEach(pet -> petService.save(pet));
		return super.save(owner);
			

	}

}
