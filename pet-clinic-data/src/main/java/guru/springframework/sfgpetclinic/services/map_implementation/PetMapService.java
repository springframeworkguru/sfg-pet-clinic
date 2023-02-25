/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.interfaces.PetService;
import guru.springframework.sfgpetclinic.services.interfaces.PetTypeService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@Service
public class PetMapService extends AbstractBaseEntityMapService<Pet> implements PetService {

	private final PetTypeService petTypeService;

	/**
	 * @param petTypeService
	 */
	public PetMapService(PetTypeService petTypeService) {
		this.petTypeService = petTypeService;
	}

	@Override
	public Pet save(Pet pet) {
		nullCheck(pet);

		PetType petType = pet.getPetType();
		petTypeService.nullCheck(petType);

		if (petType.getId() == null) {
			pet.setPetType(petTypeService.save(pet.getPetType()));
		}

		return super.save(pet);
	}

}
