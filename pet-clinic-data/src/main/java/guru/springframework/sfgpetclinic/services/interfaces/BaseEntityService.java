/**
 * 
 */
package guru.springframework.sfgpetclinic.services.interfaces;

import guru.springframework.sfgpetclinic.model.AbstractBaseEntity;

/**
 * @author Hoek0024 on 20 feb. 2023
 *
 */
public interface BaseEntityService<T extends AbstractBaseEntity> extends CrudService<T, Long> {
		public void nullCheck(T baseEntity);
}
