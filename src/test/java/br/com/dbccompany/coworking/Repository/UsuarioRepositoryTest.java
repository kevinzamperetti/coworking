package br.com.dbccompany.coworking.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.dbccompany.coworking.Entity.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void procurarUsuarioPorNome() {
        Usuario usuario = new Usuario();
        usuario.setNome( "Administrador" );
        usuario.setEmail( "admin@admin.com.br" );
        usuario.setLogin( "admin" );
        usuario.setSenha( "123456" );

        entityManager.persist( usuario );
        entityManager.flush();  //atualiza os dados

        Usuario resp = usuarioRepository.findByNome( usuario.getNome() );
        assertThat( resp.getNome() ).isEqualTo( usuario.getNome() );
    }
}
