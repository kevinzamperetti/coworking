package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.Contratacao;
import br.com.dbccompany.coworking.Entity.Espaco;
import org.springframework.data.repository.CrudRepository;

public interface EspacoRepository extends CrudRepository<Espaco, Integer> {

    Espaco findByNome( String nome );
}
