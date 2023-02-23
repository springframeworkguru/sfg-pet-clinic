/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.interfaces.VetService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@Service
public class VetMapService extends PersonMapService<Vet> implements VetService<Vet> {

}
