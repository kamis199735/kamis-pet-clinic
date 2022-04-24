package kamis199735.springframework.kamispetclinic.services.springdatajpa;

import kamis199735.springframework.kamispetclinic.model.Owner;
import kamis199735.springframework.kamispetclinic.repositories.OwnerRepository;
import kamis199735.springframework.kamispetclinic.repositories.PetRepository;
import kamis199735.springframework.kamispetclinic.repositories.PetTypeRepository;
import kamis199735.springframework.kamispetclinic.services.springdatajpa.OwnerSDJavaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OwnerSDJavaServiceTest {

	public static final String LAST_NAME = "Smith";
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	@InjectMocks
	OwnerSDJavaService ownerSDJavaService;

	Owner returnOwner;

	@BeforeEach
	void setUp() {
		returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
	}

	@Test
	void findAll() {

		Set<Owner> returnOwnersSet = new HashSet<>();
		returnOwnersSet.add(Owner.builder().id(1l).build());
		returnOwnersSet.add(Owner.builder().id(2l).build());

		Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

		Set<Owner> owners = ownerSDJavaService.findAll();

		assertNotNull(owners);
		assertEquals(2,owners.size());



	}

	@Test
	void findById() {
		Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(returnOwner));

		Owner owner = ownerSDJavaService.findById(1L);

		assertNotNull(owner);
	}

	@Test
	void findByIdNotFound() {
		Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

		Owner owner = ownerSDJavaService.findById(1L);

		assertNull(owner);
	}

	@Test
	void save() {
		Owner ownerToSave = Owner.builder().id(1L).build();

		Mockito.when(ownerSDJavaService.save(Mockito.any())).thenReturn(returnOwner);

		Owner savedOwner = ownerSDJavaService.save(ownerToSave);

		assertNotNull(savedOwner);

		verify(ownerRepository).save(any());
	}

	@Test
	void delete() {
		ownerSDJavaService.delete(returnOwner);

		verify(ownerRepository, times(1)).delete(any());

	}

	@Test
	void deleteById() {
		ownerSDJavaService.deleteById(1L);

		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void findByLastName() {



		Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(returnOwner);

		Owner smith = ownerSDJavaService.findByLastName(LAST_NAME);

		assertEquals(LAST_NAME, smith.getLastName());

		verify(ownerRepository).findByLastName(Mockito.any());
	}
}