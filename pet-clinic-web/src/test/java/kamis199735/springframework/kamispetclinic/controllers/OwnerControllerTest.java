package kamis199735.springframework.kamispetclinic.controllers;

import kamis199735.springframework.kamispetclinic.model.Owner;
import kamis199735.springframework.kamispetclinic.services.OwnerService;
import kamis199735.springframework.kamispetclinic.services.springdatajpa.OwnerSDJavaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController controller;

	Set<Owner> owners = new HashSet<>();

	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		owners = new HashSet<>();
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void listOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners")).andExpect(status().isOk())
				.andExpect(view().name("owners/index"))
				.andExpect(model().attribute("owners", hasSize(2)));
	}

	@Test
	void findOwners() throws Exception {

		mockMvc.perform(get("/owners/find"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/findOwners"))
						.andExpect(model().attributeExists("owner"));

		verifyZeroInteractions(ownerService);

	}

	@Test
	void listOwnersByIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);

		mockMvc.perform(get("/owners/index"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/index"))
						.andExpect(model().attribute("owners", hasSize(2)));

	}

	@Test
	void displayOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(get("/owners/123"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/ownerDetails"))
				.andExpect(model().attribute("owner", hasProperty("id", is(1L))));
	}

	@Test
	void processFindFormyReturnMany() throws Exception {
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build()),
				Arrays.asList(Owner.builder().id(2L).build()));

		mockMvc.perform(get("/owners"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("/owners/ownersList"))
				.andExpect(model().attribute("owners", hasSize(2)));

	}	@Test
	void processFindFormyReturnOne() throws Exception {
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build()));

		mockMvc.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("/owner/1"))
				.andExpect(model().attribute("owners", hasSize(2)));

	}
}