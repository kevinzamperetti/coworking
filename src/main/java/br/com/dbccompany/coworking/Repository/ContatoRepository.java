package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {
    Contato findByValor( String valor );
}
