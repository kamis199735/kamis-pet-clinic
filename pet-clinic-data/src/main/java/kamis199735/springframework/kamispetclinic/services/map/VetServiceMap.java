package kamis199735.springframework.kamispetclinic.services.map;

import kamis199735.springframework.kamispetclinic.model.Speciality;
import kamis199735.springframework.kamispetclinic.model.Vet;
import kamis199735.springframework.kamispetclinic.services.CrudService;
import kamis199735.springframework.kamispetclinic.services.SpecialtyService;
import kamis199735.springframework.kamispetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService){
        this.specialtyService=specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }

            });

        }
        return super.save( object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }
}
