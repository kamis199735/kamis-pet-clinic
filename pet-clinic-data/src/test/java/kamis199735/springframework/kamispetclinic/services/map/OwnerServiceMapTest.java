package kamis199735.springframework.kamispetclinic.services.map;

import kamis199735.springframework.kamispetclinic.model.Owner;
import kamis199735.springframework.kamispetclinic.services.OwnerService;
import kamis199735.springframework.kamispetclinic.services.map.OwnerServiceMap;
import kamis199735.springframework.kamispetclinic.services.map.PetServiceMap;
import kamis199735.springframework.kamispetclinic.services.map.PetTypeMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class OwnerServiceMapTest {

	OwnerService ownerService;

	final Long ownerId = 1L;
	final String lastName = "Smith";

	@BeforeEach
	void setUp() {
		ownerService = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void findAll() {
       Set<Owner> ownerSet  = ownerService.findAll();

	   assertEquals(1, ownerSet.size());
	}

	@Test
	void findById() {
		Owner owner = ownerService.findById(ownerId);

		assertEquals(ownerId, owner.getId());
	}

	@Test
	void saveExistingId() {
		Long id = 2L;
		Owner owner2 = Owner.builder().id(2L).build();

		Owner savedOwner = ownerService.save(owner2);

		assertEquals(id, savedOwner.getId());
	}

	@Test
	void saveNoId() {

		Owner savedOwner = ownerService.save(Owner.builder().build());

		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void delete() {
		ownerService.delete(ownerService.findById(ownerId));
		assertEquals(0, ownerService.findAll().size());
	}

	@Test
	void deleteById() {
		ownerService.deleteById(ownerId);
		assertEquals(0, ownerService.findAll().size());
	}

	@Test
	void findByLastName() {
		Owner smith = ownerService.findByLastName(lastName);
		assertNotNull(smith);

		assertEquals(ownerId, smith.getId());
	}

	@Test
	void findByLastNameNotFound() {
		Owner smith = ownerService.findByLastName("foo");
		assertNull(smith);

	}

}