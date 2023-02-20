/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import guru.springframework.sfgpetclinic.model.BaseEntity;

/**
 * @author Hoek0024 on 17 feb. 2023
 *
 */
public abstract class AbstractBaseEntityMapService extends AbstractMapService<BaseEntity, Long> {

	public BaseEntity save(BaseEntity baseEntity) {
		return super.save(baseEntity.getId(), baseEntity);
	}
}
