package kamis199735.springframework.kamispetclinic.repositories;

import kamis199735.springframework.kamispetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
