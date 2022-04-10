package kamis199735.springframework.kamispetclinic.services.map;

import kamis199735.springframework.kamispetclinic.model.Pet;
import kamis199735.springframework.kamispetclinic.model.PetType;
import kamis199735.springframework.kamispetclinic.services.PetService;
import kamis199735.springframework.kamispetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
