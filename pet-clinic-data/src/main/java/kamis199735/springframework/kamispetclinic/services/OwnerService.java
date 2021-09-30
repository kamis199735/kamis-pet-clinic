package kamis199735.springframework.kamispetclinic.services;

import kamis199735.springframework.kamispetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
