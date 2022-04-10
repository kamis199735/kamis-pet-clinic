package kamis199735.springframework.kamispetclinic.repositories;

import kamis199735.springframework.kamispetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);

}
