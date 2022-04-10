package kamis199735.springframework.kamispetclinic.services.springdatajpa;

import kamis199735.springframework.kamispetclinic.model.PetType;
import kamis199735.springframework.kamispetclinic.repositories.PetTypeRepository;
import kamis199735.springframework.kamispetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class PetTypeSDJavaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJavaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		return StreamSupport.stream(petTypeRepository.findAll().spliterator(), false).collect(Collectors.toSet());
	}

	@Override
	public PetType findById(Long aLong) {
		return petTypeRepository.findById(aLong).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		petTypeRepository.deleteById(aLong);
	}
}
