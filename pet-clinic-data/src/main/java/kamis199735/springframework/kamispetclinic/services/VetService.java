package kamis199735.springframework.kamispetclinic.services;

import kamis199735.springframework.kamispetclinic.model.Owner;
import kamis199735.springframework.kamispetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findaAll();
}
