package kamis199735.springframework.kamispetclinic.services.springdatajpa;

import kamis199735.springframework.kamispetclinic.model.Pet;
import kamis199735.springframework.kamispetclinic.repositories.PetRepository;
import kamis199735.springframework.kamispetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class PetSDJavaService implements PetService {

	private final PetRepository petRepository;

	public PetSDJavaService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		return StreamSupport.stream(petRepository.findAll().spliterator(),false).collect(Collectors.toSet());
	}

	@Override
	public Pet findById(Long aLong) {
		return petRepository.findById(aLong).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);

	}

	@Override
	public void deleteById(Long aLong) {
		petRepository.deleteById(aLong);
	}
}
