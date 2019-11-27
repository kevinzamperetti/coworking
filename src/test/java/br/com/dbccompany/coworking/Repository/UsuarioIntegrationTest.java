package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Controller.UsuarioController;
import br.com.dbccompany.coworking.CoworkingApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UsuarioIntegrationTest extends CoworkingApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private UsuarioController usuarioController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup( usuarioController ).build();
    }

    @Test
    public void testGetApiUsuarioStatusOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get( "/api/usuario/" )).andExpect( MockMvcResultMatchers.status().isOk() );
    }
}
