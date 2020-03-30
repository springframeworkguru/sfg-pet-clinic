package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static guru.springframework.sfgpetclinic.controllers.CrashController.URL_OUPS;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Gaetan Bloch
 * Created on 30/03/2020
 */
class CrashControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CrashController()).build();
    }

    @Test
    void triggerExceptionTest() {
        assertThrows(NestedServletException.class, () -> mockMvc.perform(get(URL_OUPS)));
    }
}