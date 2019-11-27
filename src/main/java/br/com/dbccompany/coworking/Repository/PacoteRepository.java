package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.EspacoXPacote;
import br.com.dbccompany.coworking.Entity.Pacote;
import org.springframework.data.repository.CrudRepository;

public interface PacoteRepository extends CrudRepository<Pacote, Integer> {

}
