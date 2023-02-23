/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.interfaces.PetService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@Service
public class PetMapService extends AbstractBaseEntityMapService<Pet> implements PetService<Pet> {

}
