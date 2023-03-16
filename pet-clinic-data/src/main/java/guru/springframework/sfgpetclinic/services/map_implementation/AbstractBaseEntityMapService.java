/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import java.util.Collections;

import guru.springframework.sfgpetclinic.model.AbstractBaseEntity;

/**
 * @author Hoek0024 on 17 feb. 2023
 *
 */
public abstract class AbstractBaseEntityMapService<T extends AbstractBaseEntity> extends AbstractMapService<T, Long> {

	public T save(T baseEntity) {
		nullCheck(baseEntity);
		
		if (baseEntity.getId() == null) {
				baseEntity.setId(getNextId());
		}	
		return super.save(baseEntity.getId(), baseEntity);
	}
	
	private Long getNextId() {
		if (map.keySet().isEmpty()) return 1L;
		
		return Collections.max(map.keySet()) + 1;
	}
}
