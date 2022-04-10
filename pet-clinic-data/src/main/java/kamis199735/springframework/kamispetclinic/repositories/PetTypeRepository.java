package kamis199735.springframework.kamispetclinic.repositories;

import kamis199735.springframework.kamispetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
