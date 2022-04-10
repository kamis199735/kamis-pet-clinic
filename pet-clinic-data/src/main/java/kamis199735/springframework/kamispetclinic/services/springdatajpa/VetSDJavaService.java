package kamis199735.springframework.kamispetclinic.services.springdatajpa;

import kamis199735.springframework.kamispetclinic.model.Vet;
import kamis199735.springframework.kamispetclinic.repositories.VetRepository;
import kamis199735.springframework.kamispetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJavaService implements VetService {

	private final VetRepository vetRepository;

	public VetSDJavaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().iterator().forEachRemaining(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long aLong) {
		return vetRepository.findById(aLong).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);

	}

	@Override
	public void deleteById(Long aLong) {

		vetRepository.deleteById(aLong);
	}
}
