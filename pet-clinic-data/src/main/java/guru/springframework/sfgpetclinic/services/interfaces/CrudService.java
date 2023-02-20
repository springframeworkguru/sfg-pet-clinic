/**
 * 
 */
package guru.springframework.sfgpetclinic.services.interfaces;

import java.util.Set;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
public interface CrudService<T, ID> {
	
	Set<T> findAll();
	
	T findById(ID id);
	
	T save(T object);

	void delete(T object);
	
	void deleteById(ID id);

}
