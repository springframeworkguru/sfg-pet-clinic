package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static guru.springframework.sfgpetclinic.controllers.PetController.VIEWS_PETS_CREATE_OR_UPDATE_FORM;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    private static final String URL_PETS_NEW = "/owners/1/pets/new";
    private static final String URL_PETS_EDIT = "/owners/1/pets/2/edit";

    @Mock
    PetService petService;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1l).build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1L).name("Dog").build());
        petTypes.add(PetType.builder().id(2L).name("Cat").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get(URL_PETS_NEW))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name(VIEWS_PETS_CREATE_OR_UPDATE_FORM));
    }

    @Test
    void processCreationFormTest() throws Exception {
        // Given
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        // When
        mockMvc.perform(post(URL_PETS_NEW)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Dog"))

                // Then
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));

        verify(petService).save(any());
    }

    @Test
    void processCreationFormValidationFailedTest() throws Exception {
        // Given
        when(ownerService.findById(anyLong())).thenReturn(owner);

        // When
        mockMvc.perform(post(URL_PETS_NEW).contentType(MediaType.APPLICATION_FORM_URLENCODED))

                // Then
                .andExpect(status().isOk())
                .andExpect(view().name(VIEWS_PETS_CREATE_OR_UPDATE_FORM))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));

        verifyZeroInteractions(petService);
    }

    @Test
    void initUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());

        mockMvc.perform(get(URL_PETS_EDIT))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name(VIEWS_PETS_CREATE_OR_UPDATE_FORM));
    }

    @Test
    void processUpdateFormTest() throws Exception {
        // Given
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        // When
        mockMvc.perform(post(URL_PETS_EDIT)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Dog"))

                // Then
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("owner"));

        verify(petService).save(any());
    }

    @Test
    void processUpdateFormValidationFailedTest() throws Exception {
        // When
        mockMvc.perform(post(URL_PETS_EDIT).contentType(MediaType.APPLICATION_FORM_URLENCODED))

                // Then
                .andExpect(status().isOk())
                .andExpect(view().name(VIEWS_PETS_CREATE_OR_UPDATE_FORM))
                .andExpect(model().attributeExists("pet"));

        verifyZeroInteractions(petService);
    }

    @Test
    void populatePetTypes() {
        //todo impl
    }

    @Test
    void findOwner() {
        //todo impl
    }

    @Test
    void initOwnerBinder() {
        //todo impl
    }
}