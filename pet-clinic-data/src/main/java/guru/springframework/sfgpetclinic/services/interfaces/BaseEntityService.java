/**
 * 
 */
package guru.springframework.sfgpetclinic.services.interfaces;

import guru.springframework.sfgpetclinic.model.BaseEntity;

/**
 * @author Hoek0024 on 20 feb. 2023
 *
 */
public interface BaseEntityService<T extends BaseEntity> extends CrudService<T, Long> {
		public void nullCheck(T baseEntity);
}
