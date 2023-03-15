/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.interfaces.SpecialityService;
import guru.springframework.sfgpetclinic.services.interfaces.VetService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@Service
@Profile({"default", "map"})
public class VetMapService extends PersonMapService<Vet> implements VetService {

	private final SpecialityService specialityService;

	/**
	 * @param specialityService
	 */
	public VetMapService(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	public Vet save(Vet vet) {
		if (vet == null) {
			return null;
		}

		vet.getSpecialities().forEach(s -> specialityService.save(s));
		return super.save(vet);
	}
}
