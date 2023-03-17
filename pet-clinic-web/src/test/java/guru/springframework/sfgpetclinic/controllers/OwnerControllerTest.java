/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.interfaces.OwnerService;

/**
 * @author Hoek0024 on 17 mrt. 2023
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController ownerController;

	Set<Owner> owners;

	MockMvc mockMvc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<>();
		owners.add(Owner.builder().id(1l).build());
		owners.add(Owner.builder().id(2l).build());

		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.controllers.OwnerController#listOwners(org.springframework.ui.Model)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testListOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);

		mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("owners/index"))
				.andExpect(model().attribute("owners", hasSize(2)));
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.controllers.OwnerController#listOwners(org.springframework.ui.Model)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testListOwnersByIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);

		mockMvc.perform(get("/owners/index")).andExpect(status().isOk()).andExpect(view().name("owners/index"))
				.andExpect(model().attribute("owners", hasSize(2)));
	}

	/**
	 * Test method for
	 * {@link guru.springframework.sfgpetclinic.controllers.OwnerController#findOwners()}.
	 */
	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("notimplemented"));
		verifyZeroInteractions(ownerService);
	}

}
