package kamis199735.springframework.kamispetclinic.services.springdatajpa;

import kamis199735.springframework.kamispetclinic.model.Owner;
import kamis199735.springframework.kamispetclinic.repositories.OwnerRepository;
import kamis199735.springframework.kamispetclinic.repositories.PetRepository;
import kamis199735.springframework.kamispetclinic.repositories.PetTypeRepository;
import kamis199735.springframework.kamispetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJavaService implements OwnerService {

	private final OwnerRepository ownerRepository;

	private final PetRepository petRepository;

	private final PetTypeRepository petTypeRepository;

	public OwnerSDJavaService(OwnerRepository ownerRepository, PetRepository petRepository,
							  PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long along) {
		Optional<Owner> owner = ownerRepository.findById(along);
		return owner.orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		ownerRepository.deleteById(aLong);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		return ownerRepository.findAllByLastNameLike(lastName);
	}
}
