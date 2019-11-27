package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Controller.TipoContatoController;
import br.com.dbccompany.coworking.Controller.UsuarioController;
import br.com.dbccompany.coworking.CoworkingApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TipoContatoIntegrationTest extends CoworkingApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private TipoContatoController tipoContatoController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup( tipoContatoController ).build();
    }

    @Test
    public void testGetApiTipoContatoStatusOk() throws Exception {
        this.mockMvc.perform( MockMvcRequestBuilders.get( "/api/tipocontato/" ) )
                .andExpect( MockMvcResultMatchers.status().isOk() );
    }
}
