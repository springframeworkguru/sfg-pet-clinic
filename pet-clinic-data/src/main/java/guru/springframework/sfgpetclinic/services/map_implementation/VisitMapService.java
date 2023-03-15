/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.interfaces.VisitService;

/**
 * @author Hoek0024 on 15 mrt. 2023
 *
 */
@Service
@Profile("map")
public class VisitMapService extends AbstractBaseEntityMapService<Visit> implements VisitService {

	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null
				|| visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid visit");
		}
		return super.save(visit);
	}
}
