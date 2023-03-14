/**
 * 
 */
package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Hoek0024 on 14 mrt. 2023
 *
 */
public abstract class AbstractSDJpaService<T, ID, R extends CrudRepository<T, ID>> {
	
	protected R repository;
	
    public AbstractSDJpaService(R repository) {
        this.repository = repository;
    }
	
	public Set<T> findAll() {
		Set<T> objects = new HashSet<>();
		repository.findAll().forEach(objects::add);
		return objects;
	}

	public T findById(ID id) {
		return repository.findById(id).orElse(null);
	}

	public T save(T object) {
		return repository.save(object);
	}

	public void delete(T object) {
		repository.delete(object);
	}

	public void deleteById(ID id) {
		repository.deleteById(id);
	}
	
	public void nullCheck(T object) {
		if (object == null) {
			throw new RuntimeException("Entity can not be null");
		}
	}
}
