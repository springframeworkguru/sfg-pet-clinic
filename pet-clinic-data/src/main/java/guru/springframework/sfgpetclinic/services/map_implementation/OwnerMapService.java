/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.interfaces.OwnerService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@Service
public class OwnerMapService extends PersonMapService<Owner> implements OwnerService<Owner> {


}
