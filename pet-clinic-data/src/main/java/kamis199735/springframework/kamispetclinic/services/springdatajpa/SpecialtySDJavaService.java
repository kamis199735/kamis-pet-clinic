package kamis199735.springframework.kamispetclinic.services.springdatajpa;

import kamis199735.springframework.kamispetclinic.model.Speciality;
import kamis199735.springframework.kamispetclinic.repositories.SpecialtyRepository;
import kamis199735.springframework.kamispetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class SpecialtySDJavaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;

	public SpecialtySDJavaService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		return StreamSupport.stream(specialtyRepository.findAll().spliterator(),false).collect(Collectors.toSet());
	}

	@Override
	public Speciality findById(Long aLong) {
		return specialtyRepository.findById(aLong).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		specialtyRepository.deleteById(aLong);
	}
}
