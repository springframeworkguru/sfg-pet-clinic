package guru.springframework.sfgpetclinic.repositories.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public class CrudMapRepository<T extends BaseEntity, ID extends Long> implements CrudRepository<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public <S extends T> S save(S s) {
        if(s != null) {
            if(s.getId() == null){
                s.setId(getNextId());
            }
            map.put(s.getId(), s);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return s;
    }

    private Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.of(map.get(id));
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
