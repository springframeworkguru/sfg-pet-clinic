package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jt on 7/29/18.
 */
@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
