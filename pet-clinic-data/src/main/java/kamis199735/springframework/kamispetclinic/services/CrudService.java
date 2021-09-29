package kamis199735.springframework.kamispetclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {

    Set<T> findAll();

    T findById(ID id);

    save(T);
}
