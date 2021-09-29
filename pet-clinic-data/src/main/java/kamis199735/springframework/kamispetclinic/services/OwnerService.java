package kamis199735.springframework.kamispetclinic.services;

import kamis199735.springframework.kamispetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findaAll();
}
