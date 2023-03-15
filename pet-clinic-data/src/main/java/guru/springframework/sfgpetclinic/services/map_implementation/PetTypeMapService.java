/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.interfaces.PetTypeService;

/**
 * @author Hoek0024 on 23 feb. 2023
 *
 */
@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractBaseEntityMapService<PetType> implements PetTypeService {

}
