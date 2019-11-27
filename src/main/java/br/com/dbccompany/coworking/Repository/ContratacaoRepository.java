package br.com.dbccompany.coworking.Repository;

import br.com.dbccompany.coworking.Entity.Contato;
import br.com.dbccompany.coworking.Entity.Contratacao;
import org.springframework.data.repository.CrudRepository;

public interface ContratacaoRepository extends CrudRepository<Contratacao, Integer> {

}
