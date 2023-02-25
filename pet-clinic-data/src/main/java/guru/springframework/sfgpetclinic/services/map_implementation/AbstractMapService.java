/**
 * 
 */
package guru.springframework.sfgpetclinic.services.map_implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
public abstract class AbstractMapService<T, ID> {

	protected Map<ID, T> map = new HashMap<>(); 
	
	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	public T findById(ID id) {
		return map.get(id);
	}
	
	public T save(ID id, T object) {
		map.put(id, object);
		return object;
	}
	
	public void deleteById(ID id) {
		map.remove(id);
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	public void nullCheck(T object) {
		if (object == null) {
			throw new RuntimeException("Entity can not be null");
		}
	}
}
