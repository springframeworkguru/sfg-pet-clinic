/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.interfaces.SpecialityService;

/**
 * @author Hoek0024 on 27 feb. 2023
 *
 */
@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractBaseEntityMapService<Speciality> implements SpecialityService {

}
