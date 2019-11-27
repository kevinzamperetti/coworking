package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.TipoContato;
import br.com.dbccompany.coworking.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByNome( String nome );
    Usuario findByLogin( String login );
}
