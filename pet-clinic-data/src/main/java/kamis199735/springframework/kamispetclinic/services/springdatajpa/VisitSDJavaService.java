package kamis199735.springframework.kamispetclinic.services.springdatajpa;

import kamis199735.springframework.kamispetclinic.model.Visit;
import kamis199735.springframework.kamispetclinic.repositories.VisitRepository;
import kamis199735.springframework.kamispetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class VisitSDJavaService implements VisitService {

	private final VisitRepository visitRepository;

	public VisitSDJavaService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		return StreamSupport.stream(visitRepository.findAll().spliterator(),false).collect(Collectors.toSet());
	}

	@Override
	public Visit findById(Long aLong) {
		return visitRepository.findById(aLong).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		visitRepository.deleteById(aLong);
	}
}
