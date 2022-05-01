package kamis199735.springframework.kamispetclinic.services.map;

import kamis199735.springframework.kamispetclinic.model.Owner;
import kamis199735.springframework.kamispetclinic.model.Pet;
import kamis199735.springframework.kamispetclinic.services.CrudService;
import kamis199735.springframework.kamispetclinic.services.OwnerService;
import kamis199735.springframework.kamispetclinic.services.PetService;
import kamis199735.springframework.kamispetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {


        if(object != null){

            if(object.getPets()!=null) {
                object.getPets().forEach(pet -> {
                   if (pet.getPetType() != null) {
                       pet.setPetType(petTypeService.save(pet.getPetType()));
                   } else {
                       throw new RuntimeException("Pet Type is Required");
                   }
                   if(pet.getId() == null){
                       Pet savedPet = petService.save(pet);
                       pet.setId(savedPet.getId());
                   }

                });
            }

            return super.save(object);
        } else {
            return null;
        }


    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public Owner findByLastName(String lastName) {

        return findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst().orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}
