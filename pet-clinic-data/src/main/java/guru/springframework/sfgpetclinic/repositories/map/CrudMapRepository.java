package guru.springframework.sfgpetclinic.repositories.map;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class CrudMapRepository<T, ID> implements CrudRepository<T, ID> {

    @Override
    public <S extends T> S save(S s) {
        System.out.println(s.getClass().getSimpleName() + " Map Repository : save()");
        return null;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
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

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
